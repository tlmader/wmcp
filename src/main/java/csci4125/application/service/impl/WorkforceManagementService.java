package csci4125.application.service.impl;

import csci4125.application.model.*;
import csci4125.application.repository.ICrudRepository;
import csci4125.application.repository.IWorksRepository;
import csci4125.application.service.IWorkforceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return worksRepository.create(personRepository.get(personId).getId(), jobRepository.get(jobId).getId());
    }

    @Override
    public List<Job> findJobsForPersonByKnownSkills(String personId) {
        List<Job> jobs = jobRepository.getAll();
        Person person = personRepository.get(personId);
        if (person == null) {
            return null;
        }
        List<Skill> knownSkills = person.getKnownSkills();
        return jobs.stream()
                .filter(x -> x.getJobProfile().getRequiredSkills().containsAll(knownSkills))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findPersonsForJobProfileByRequiredSkills(String jobProfileId) {
        List<Person> persons = personRepository.getAll();
        JobProfile jobProfile = jobProfileRepository.get(jobProfileId);
        if (jobProfile == null) {
            return null;
        }
        List<Skill> requiredSkills = jobProfile.getRequiredSkills();
        return persons.stream()
                .filter(x -> x.getKnownSkills().containsAll(requiredSkills))
                .collect(Collectors.toList());
    }
}
