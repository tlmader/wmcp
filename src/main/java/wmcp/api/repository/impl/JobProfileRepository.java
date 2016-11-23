package wmcp.api.repository.impl;

import wmcp.api.model.JobProfile;
import org.springframework.stereotype.Component;

/**
 * Implements data access methods for JobProfile entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Component
public class JobProfileRepository extends CrudRepository<JobProfile> {

    public JobProfileRepository() {
        super((x, y) -> {
            x.setTitle(y.getTitle());
            x.setDescription(y.getDescription());
            x.setAvgPay(y.getAvgPay());
        }, JobProfile.class);
    }
}
