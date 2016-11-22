package csci4125.application.repository.impl;

import csci4125.application.model.Job;
import csci4125.application.model.Person;
import csci4125.application.model.Works;
import csci4125.application.repository.IWorksRepository;
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
 * Implements data access methods for Person to Job associations.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
@Component
public class WorksRepository implements IWorksRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Works get(String personId, String jobId) {
        if (personId == null || jobId == null) {
            return null;
        }
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Works.class);
        criteria.add(Restrictions.eq("personId", personId.toLowerCase()));
        criteria.add(Restrictions.eq("jobId", jobId.toLowerCase()));
        List<Works> results = criteria.list();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }

    @Override
    public Works create(Person person, Job job) {
        if (person == null || job == null) {
            throw new ClientErrorException("Entity is null", Response.Status.BAD_REQUEST);
        } else if (get(person.getId(), job.getId()) != null) {
            throw new ClientErrorException("Person to Job association exists", Response.Status.CONFLICT);
        }
        Works works = new Works(person, job);
        works.setPerson(person);
        works.setJob(job);
        Session session = sessionFactory.getCurrentSession();
        session.save(works);
        return works;
    }
}
