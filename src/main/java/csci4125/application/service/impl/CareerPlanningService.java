package csci4125.application.service.impl;

import csci4125.application.model.Company;
import csci4125.application.model.Course;
import csci4125.application.model.Job;
import csci4125.application.repository.ICrudRepository;
import csci4125.application.service.ICareerPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements service workflow methods for career planning.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
@Service
public class CareerPlanningService implements ICareerPlanningService {

    @Autowired
    ICrudRepository<Job> jobRepository;
    @Autowired
    ICrudRepository<Company> companyRepository;

    @Override
    public List<Job> findJobsByPrimarySector(String primarySector) {
        return jobRepository.getAll().stream()
                .filter(x -> x.getCompany().getPrimarySector().equals(primarySector))
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> findCoursesForJobProfile(String jobProfileId, String personId) {
        return null;
    }
}
