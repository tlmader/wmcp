package wmcp.api.controller;

import wmcp.api.model.Person;
import wmcp.api.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Defines the REST API for Person entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
@RestController
@RequestMapping("api/object")
public class PersonController {

    @Qualifier("personService")
    @Autowired
    private ICrudService<Person> service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Person> get(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.service.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public ResponseEntity<Person> create(@PathVariable("id") String id, @RequestBody Person entity) {
        return new ResponseEntity<>(this.service.create(id, entity), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Person> update(@PathVariable("id") String id, @RequestBody Person entity) {
        return new ResponseEntity<>(this.service.update(id, entity), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Person> delete(@PathVariable("id") String id) {
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}