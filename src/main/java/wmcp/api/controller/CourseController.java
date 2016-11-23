package wmcp.api.controller;

import wmcp.api.model.Course;
import wmcp.api.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Defines the REST API for Course entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
@RestController
@RequestMapping("api/course")
public class CourseController {

    @Qualifier("courseService")
    @Autowired
    private ICrudService<Course> service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Course> get(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.service.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public ResponseEntity<Course> create(@PathVariable("id") String id, @RequestBody Course entity) {
        return new ResponseEntity<>(this.service.create(id, entity), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Course> update(@PathVariable("id") String id, @RequestBody Course entity) {
        return new ResponseEntity<>(this.service.update(id, entity), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Course> delete(@PathVariable("id") String id) {
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}