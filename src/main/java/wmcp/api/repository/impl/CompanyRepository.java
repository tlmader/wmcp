package wmcp.api.repository.impl;

import wmcp.api.model.Company;
import org.springframework.stereotype.Component;

/**
 * Implements data access methods for Company entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Component
public class CompanyRepository extends CrudRepository<Company> {

    public CompanyRepository() {
        super((x, y) -> {
            x.setName(y.getName());
            x.setAddress(y.getAddress());
            x.setPrimarySector(y.getPrimarySector());
            x.setWebsite(y.getWebsite());
        }, Company.class);
    }
}
