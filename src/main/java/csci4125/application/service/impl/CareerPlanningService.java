package csci4125.application.service.impl;

import csci4125.application.model.*;
import csci4125.application.repository.ICrudRepository;
import csci4125.application.service.ICareerPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    ICrudRepository<JobProfile> jobProfileRepository;
    @Autowired
    ICrudRepository<Company> companyRepository;
    @Autowired
    ICrudRepository<Course> courseRepository;
    @Autowired
    ICrudRepository<Person> personRepository;

    @Override
    public List<Job> findJobsByPrimarySector(String primarySector) {
        return jobRepository.getAll().stream()
                .filter(j -> j.getCompany().getPrimarySector().equals(primarySector))
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> findCourseSetForJobProfile(String jobProfileId, String personId) {
        List<Skill> requiredSkills;
        Person person = personRepository.get(personId);
        if (person != null) {
            List<Skill> knownSkills = person.getKnownSkills();
            requiredSkills = jobProfileRepository.get(jobProfileId).getRequiredSkills().stream()
                    .filter(s -> !knownSkills.contains(s))
                    .collect(Collectors.toList());
        } else {
            requiredSkills = jobProfileRepository.get(jobProfileId).getRequiredSkills();
        }
        List<Course> courses = courseRepository.getAll();
        if (courses == null) {
            return null;
        }
        List<Course> courseSet = new ArrayList<>();
        while (!requiredSkills.isEmpty() && !courses.isEmpty()) {
            courses = courses.stream()
                    .filter(c -> c.getTeaches().stream()
                            .filter(t -> !requiredSkills.contains(t))
                            .collect(Collectors.toList()).isEmpty())
                    .collect(Collectors.toList());
            if (!courses.isEmpty()) {
                courses.sort(getCourseComparator(requiredSkills));
                courses.get(0).getTeaches().stream()
                        .filter(requiredSkills::contains)
                        .forEach(requiredSkills::remove);
                courseSet.add(courses.remove(0));
            }
        }
        return courseSet;
    }

    /**
     * Compares two Courses for prioritization, favoring greater number of required Skills and fewer unneeded Skills.
     *
     * @param requiredSkills a List of required skills
     * @return 1 if greater than, -1 if less than, and 0 if equal
     */
    private Comparator<Course> getCourseComparator(List<Skill> requiredSkills) {
        return (c1, c2) -> {
            List<Skill> c1Teaches = c1.getTeaches();
            List<Skill> c2Teaches = c2.getTeaches();
            int c1Required = Collections.frequency(c1Teaches, requiredSkills);
            int c2Required = Collections.frequency(c2Teaches, requiredSkills);
            int c1Extra = c1Teaches.size() - c1Required;
            int c2Extra = c2Teaches.size() - c2Required;
            if (c1Required > c2Required) {
                return 1;
            } else if (c1Required < c2Required) {
                return -1;
            } else if (c1Required == c2Required && c1Extra < c2Extra) {
                return 1;
            }
            return 0;
        };
    }
}
