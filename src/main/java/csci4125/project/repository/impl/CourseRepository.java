package csci4125.project.repository.impl;

import csci4125.project.repository.IRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Implements data access methods for Object entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-16
 */
@Component("resourceAccessor")
public class CourseRepository implements IRepository<Object> {

    SessionFactory sessionFactory;

    @Autowired
    public CourseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Object> getAll() {
        Criteria allCriteria = sessionFactory.getCurrentSession().createCriteria(Object.class);
        return allCriteria.list();
    }

    @Override
    @Transactional
    public Object get(String id) {
        if (id == null) {
            return null;
        }
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Object.class);
        criteria.add(Restrictions.eq("id", id.toLowerCase()));
        List<Object> results = criteria.list();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }

    @Override
    @Transactional
    public Object create(Object entity) {
        if (entity.getId() == null) {
            throw new E("Object ID Is Null.", Response.Status.BAD_REQUEST);
        } else if (get(entity.getId()) != null) {
            throw new ClientErrorException("Object ID In Use.", Response.Status.CONFLICT);
        }
        entity.setId(entity.getId().toLowerCase());
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public Object update(Object entity) {
        Object found = get(entity.getId());
        if (found == null) {
            throw new ClientErrorException("Object Not Found", Response.Status.NOT_FOUND);
        }
        // TODO: Set properties of found to entity (excluding ID and version)
        found.setName(entity.getName());
        Session session = sessionFactory.getCurrentSession();
        session.merge(found);
        return found;
    }

    @Override
    @Transactional
    public void delete(String id) {
        Object found = get(id);
        if (found == null) {
            throw new ClientErrorException("Object Not Found", Response.Status.NOT_FOUND);
        }
        Session session = sessionFactory.getCurrentSession();
        session.delete(found);
    }
}
