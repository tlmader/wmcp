package wmcp.api.service.impl;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import wmcp.api.model.*;
import wmcp.api.repository.ICrudRepository;
import wmcp.api.service.ICareerPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.*;
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
    ICrudRepository<Person> personRepository;
    @Autowired
    ICrudRepository<Course> courseRepository;
    @Autowired
    ICrudRepository<Skill> skillRepository;
    @Autowired
    ICrudRepository<Job> jobRepository;
    @Autowired
    ICrudRepository<JobProfile> jobProfileRepository;
    @Autowired
    ICrudRepository<Company> companyRepository;
    @Autowired
    ICrudRepository<Section> sectionRepository;

    @Override
    public Person addPersonWithQualifications(String id, Person person) {
        if (!Objects.equals(id, person.getId())) {
            throw new WebApplicationException("ID must equal 'id' attribute in body", Response.Status.BAD_REQUEST);
        }
        List<Skill> earnedSkills = new ArrayList<>();
        List<Section> sections = sectionRepository.getAll();
        List<String> sectionIds = sections.stream().map(Section::getId).collect(Collectors.toList());
        List<Section> takesSections = person.getTakesSections();
        List<String> takesSectionIds = takesSections.stream().map(Section::getId).collect(Collectors.toList());
        Errors errors = new BeanPropertyBindingResult(takesSections, "takesSections");
        takesSections.stream()
                .filter(s -> !sectionIds.contains(s.getId()))
                .forEach(s -> errors.reject("Section does not exist: " + s.getId()));
        sections = sections.stream()
                .filter(s -> takesSectionIds.contains(s.getId()))
                .collect(Collectors.toList());
        sections.stream()
                .filter(s -> s.getCompleteDate() == null || s.getCompleteDate().getTime() > System.currentTimeMillis())
                .forEach(s -> errors.reject("Section incomplete: " + s.getId()));
        if (errors.hasErrors()) {
            throw new WebApplicationException(errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getCode)
                    .collect(Collectors.joining("\n")), Response.Status.BAD_REQUEST);
        }
        sections.forEach(s -> earnedSkills.addAll(s.getCourse().getTeaches()));
        person.setTakesSections(sections);
        person.setKnownSkills(earnedSkills);
        return personRepository.create(person);
    }

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
