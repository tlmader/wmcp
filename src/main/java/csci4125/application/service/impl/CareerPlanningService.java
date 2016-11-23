package csci4125.application.service.impl;

import csci4125.application.model.Course;
import csci4125.application.model.Job;
import csci4125.application.service.ICareerPlanningService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements service workflow methods for career planning.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
@Service
public class CareerPlanningService implements ICareerPlanningService {

    @Override
    public List<Job> findJobsByPrimarySector(String primarySector) {
        return null;
    }

    @Override
    public List<Course> findCoursesForJobProfile(String jobProfileId, String personId) {
        return null;
    }
}
