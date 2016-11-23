package wmcp.api.service.impl;

import wmcp.api.model.Company;
import wmcp.api.repository.ICrudRepository;
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
