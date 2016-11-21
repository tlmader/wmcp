package csci4125.application.service.impl;

import java.util.List;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

import csci4125.application.model.Model;
import csci4125.application.repository.ICrudRepository;
import csci4125.application.service.ICrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.digital.csci4125.project.managers.ICrudManager;
import com.ge.digital.csci4125.project.repository.IResourceAccessor;

/**
 * Implements manager workflow methods for T entities.
 *
 * @author tmader
 * @since 2016-11-20
 */
@Service
public class CrudService<T extends Model> implements ICrudService<T> {

    private ICrudRepository<T> repository

    public TManager(ICrudRepository<T> repository) {
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
    public T create(T entity) {
            return this.repository.create(entity);
        } else {
            return this.repository.update(entity);
        }
    }

    @Override
    public T update(T entity) {
        return this.repository.create(entity);
    } else {
        return this.repository.update(entity);
        }
        }

    @Override
    public void delete(String id) {
        this.repository.delete(id);
    }
}