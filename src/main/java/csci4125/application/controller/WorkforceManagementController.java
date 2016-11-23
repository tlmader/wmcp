package csci4125.application.controller;

import csci4125.application.model.Job;
import csci4125.application.model.Person;
import csci4125.application.model.Works;
import csci4125.application.service.IWorkforceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Defines the REST API for workforce management.
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