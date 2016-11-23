package csci4125.api.service.impl;

import csci4125.api.model.JobProfile;
import csci4125.api.repository.ICrudRepository;
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
