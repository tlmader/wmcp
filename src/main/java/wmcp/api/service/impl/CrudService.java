package wmcp.api.service.impl;

import wmcp.api.model.BaseEntity;
import wmcp.api.repository.ICrudRepository;
import wmcp.api.service.ICrudService;
import org.springframework.stereotype.Service;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

/**
 * Implements service workflow methods for BaseEntity entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
@Service
abstract class CrudService<T extends BaseEntity> implements ICrudService<T> {

    private ICrudRepository<T> repository;

    public CrudService(ICrudRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getAll() {
        return this.repository.getAll();
    }

    @Override
    public T get(String id) {
        T entity = this.repository.get(id);
        if (entity == null) {
            throw new ClientErrorException(String.valueOf(id), Response.Status.NOT_FOUND);
        }
        return entity;
    }

    @Override
    public T create(String id, T entity) {
        if (!Objects.equals(id, entity.getId())) {
            throw new ClientErrorException("ID must equal 'id' attribute in body", Response.Status.BAD_REQUEST);
        }
        entity.setId(id);
        return this.repository.create(entity);
    }

    @Override
    public T update(String id, T entity) {
        if (!Objects.equals(id, entity.getId())) {
            throw new ClientErrorException("ID must equal 'id' attribute in body", Response.Status.BAD_REQUEST);
        }
        entity.setId(id);
        return this.repository.update(entity);
    }

    @Override
    public void delete(String id) {
        this.repository.delete(id);
    }
}