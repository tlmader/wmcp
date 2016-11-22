package csci4125.application.service.impl;

import csci4125.application.model.Job;
import csci4125.application.model.Person;
import csci4125.application.model.Skill;
import csci4125.application.repository.ICrudRepository;
import csci4125.application.service.IWorkforceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
    ICrudRepository<Job> jobRepository;
    @Autowired
    ICrudRepository<Person> personRepository;

    @Override
    public Map<String, Object> assignJobToPerson(String jobId, String personId) {
        Job job = jobRepository.get(jobId);
        Person person = personRepository.get(personId);

        return null;
    }

    @Override
    public List<Job> getJobsForPersonByKnownSkills(String personId) {
        List<Job> jobs = jobRepository.getAll();
        Person person = personRepository.get(personId);
        List<Skill> knownSkills = person.getKnownSkills();
        return jobs.stream()
                .filter(x -> x.getJobProfile().getRequiredSkills().containsAll(knownSkills))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getPersonsForJobByRequiredSkills(String jobId) {
        List<Person> persons = personRepository.getAll();
        Job job = jobRepository.get(jobId);
        List<Skill> requiredSkills = job.getJobProfile().getRequiredSkills();
        return persons.stream()
                .filter(x -> x.getKnownSkills().containsAll(requiredSkills))
                .collect(Collectors.toList());
    }
}
