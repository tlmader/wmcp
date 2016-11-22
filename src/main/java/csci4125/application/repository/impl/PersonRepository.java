package csci4125.application.repository.impl;

import csci4125.application.model.Job;
import csci4125.application.model.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

/**
 * Implements data access methods for Person entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Component
public class PersonRepository extends CrudRepository<Person> {

    public PersonRepository() {
        super((x, y) -> {
            x.setName(y.getName());
            x.setAddress(y.getAddress());
            x.setPhoneNum(y.getPhoneNum());
            x.setEmail(y.getEmail());
            x.setGender(y.getGender());
        }, Person.class);
    }
}
