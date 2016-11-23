package wmcp.api.service.impl;

import wmcp.api.model.Person;
import wmcp.api.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements service workflow methods for Person entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class PersonService extends CrudService<Person> {

    @Autowired
    public PersonService(ICrudRepository<Person> repository) {
        super(repository);
    }
}
