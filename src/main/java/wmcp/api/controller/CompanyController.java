package wmcp.api.controller;

import wmcp.api.model.Company;
import wmcp.api.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Defines the REST API for Company entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
@RestController
@RequestMapping("api/company")
public class CompanyController {

    @Qualifier("companyService")
    @Autowired
    private ICrudService<Company> service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Company> get(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.service.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public ResponseEntity<Company> create(@PathVariable("id") String id, @RequestBody Company entity) {
        return new ResponseEntity<>(this.service.create(id, entity), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Company> update(@PathVariable("id") String id, @RequestBody Company entity) {
        return new ResponseEntity<>(this.service.update(id, entity), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Company> delete(@PathVariable("id") String id) {
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}