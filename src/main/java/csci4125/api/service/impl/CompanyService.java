package csci4125.api.service.impl;

import csci4125.api.model.Company;
import csci4125.api.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements service workflow methods for Company entities.
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
