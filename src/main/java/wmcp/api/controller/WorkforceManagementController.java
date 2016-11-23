package wmcp.api.controller;

import wmcp.api.model.Job;
import wmcp.api.model.Person;
import wmcp.api.model.Works;
import wmcp.api.service.IWorkforceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Defines the REST API for workforce management workflows.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
@RestController
@RequestMapping("api/workforcemanagement")
public class WorkforceManagementController {

    @Autowired
    private IWorkforceManagementService service;

    @RequestMapping(value = {"/assign/{personId}/{jobId}"}, method = RequestMethod.PUT)
    public ResponseEntity<Works> assignPersonToJob(@PathVariable("personId") String personId, @PathVariable("jobId") String jobId) {
        return new ResponseEntity<>(this.service.assignPersonToJob(personId, jobId), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/jobs/{personId}"}, method = RequestMethod.GET)
    public ResponseEntity<List<Job>> findJobsForPersonByKnownSkills(@PathVariable("personId") String personId) {
        return new ResponseEntity<>(this.service.findJobsForPersonByKnownSkills(personId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/persons/{jobProfileId}"}, method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findPersonsForJobProfileByRequiredSkills(@PathVariable("jobProfileId") String jobProfileId) {
        return new ResponseEntity<>(this.service.findPersonsForJobProfileByRequiredSkills(jobProfileId), HttpStatus.OK);
    }
}