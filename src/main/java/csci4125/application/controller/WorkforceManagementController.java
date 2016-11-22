package csci4125.application.controller;

import csci4125.application.model.Job;
import csci4125.application.model.Person;
import csci4125.application.service.IWorkforceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = {"/assign/{jobId}/{personId}"}, method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> assignJobToPerson(@PathVariable("jobId") String jobId, @PathVariable("personId") String personId) {
        return new ResponseEntity<>(this.service.assignJobToPerson(jobId, personId), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/find/jobs/{personId}"}, method = RequestMethod.GET)
    public ResponseEntity<List<Job>> findJobsForPersonByKnownSkills(@PathVariable("personId") String personId) {
        return new ResponseEntity<>(this.service.findJobsForPersonByKnownSkills(personId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/find/persons/{jobId}"}, method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findPersonsForJobByRequiredSkills(@PathVariable("jobId") String jobId) {
        return new ResponseEntity<>(this.service.findPersonsForJobByRequiredSkills(jobId), HttpStatus.OK);
    }
}