package wmcp.api.service.impl;

import wmcp.api.model.JobProfile;
import wmcp.api.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements service workflow methods for JobProfile entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class JobProfileService extends CrudService<JobProfile> {

    @Autowired
    public JobProfileService(ICrudRepository<JobProfile> repository) {
        super(repository);
    }
}
