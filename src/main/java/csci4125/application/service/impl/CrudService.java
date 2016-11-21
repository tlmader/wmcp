package csci4125.application.service.impl;

import csci4125.application.model.Model;
import csci4125.application.repository.ICrudRepository;
import csci4125.application.service.ICrudService;
import org.springframework.stereotype.Service;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Implements manager workflow methods for T entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
@Service
abstract class CrudService<T extends Model> implements ICrudService<T> {

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
        return this.repository.create(entity);
    }

    @Override
    public T update(String id, T entity) {
        return this.repository.update(entity);
    }

    @Override
    public void delete(String id) {
        this.repository.delete(id);
    }
}