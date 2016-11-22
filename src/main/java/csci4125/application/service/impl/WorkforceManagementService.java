package csci4125.application.service.impl;

import csci4125.application.model.Job;
import csci4125.application.model.Person;
import csci4125.application.service.IWorkforceManagementService;

import java.util.List;
import java.util.Map;

/**
 * Implements service workflow methods for workforce management.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/21/2016
 */
public class WorkforceManagementService implements IWorkforceManagementService {

    @Override
    public Map<String, Object> assignJobToPerson(String jobId, String personId) {
        return null;
    }

    @Override
    public List<Job> getJobsForPersonByKnownSkills(String personId) {
        return null;
    }

    @Override
    public List<Person> getPersonsForJobProfileByRequiredSkills(String jobProfileId) {
        return null;
    }
}
