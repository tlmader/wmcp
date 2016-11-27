package wmcp.api.service.impl;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import wmcp.api.model.*;
import wmcp.api.repository.ICrudRepository;
import wmcp.api.repository.IWorksRepository;
import wmcp.api.service.IWorkforceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements service workflow methods for workforce management.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/21/2016
 */
@Service
public class WorkforceManagementService implements IWorkforceManagementService {

    @Autowired
    ICrudRepository<Person> personRepository;
    @Autowired
    ICrudRepository<Job> jobRepository;
    @Autowired
    ICrudRepository<JobProfile> jobProfileRepository;
    @Autowired
    IWorksRepository worksRepository;

    @Override
    public Works assignPersonToJob(String personId, String jobId) {
        Job job = jobRepository.get(jobId);
        Person person = personRepository.get(personId);
        List<Skill> knownSkills = person.getKnownSkills();
        Errors errors = new BeanPropertyBindingResult(knownSkills, "requiredSkills");
        job.getJobProfile().getRequiredSkills().stream()
                .filter(k -> !knownSkills.contains(k))
                .forEach(u -> errors.reject("Missing skill: " + u.getTitle()));
        if (errors.hasErrors()) {
            throw new WebApplicationException(errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getCode)
                    .collect(Collectors.joining("\n")), Response.Status.BAD_REQUEST);
        } else {
            return worksRepository.create(person.getId(), job.getId());
        }
    }

    @Override
    public List<Job> findJobsForPersonByKnownSkills(String personId) {
        Person person = personRepository.get(personId);
        if (person == null) {
            return null;
        }
        List<Skill> knownSkills = person.getKnownSkills();
        return jobRepository.getAll().stream()
                .filter(j -> j.getJobProfile().getRequiredSkills().containsAll(knownSkills))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findPersonsForJobProfileByRequiredSkills(String jobProfileId) {
        JobProfile jobProfile = jobProfileRepository.get(jobProfileId);
        if (jobProfile == null) {
            return null;
        }
        List<Skill> requiredSkills = jobProfile.getRequiredSkills();
        return personRepository.getAll().stream()
                .filter(p -> p.getKnownSkills().containsAll(requiredSkills))
                .collect(Collectors.toList());
    }
}
