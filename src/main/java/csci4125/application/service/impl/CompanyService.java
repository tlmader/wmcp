package csci4125.application.service.impl;

import csci4125.application.model.Company;
import csci4125.application.model.Course;
import csci4125.application.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements manager workflow methods for Company entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class CompanyService extends CrudService<Company> {

    @Autowired
    public CompanyService(ICrudRepository<Company> repository) {
        super(repository);
    }
}
