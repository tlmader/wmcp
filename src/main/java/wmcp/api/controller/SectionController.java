package wmcp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wmcp.api.model.Section;
import wmcp.api.service.ICrudService;

import java.util.List;

/**
 * Defines the REST API for Section entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
@RestController
@RequestMapping("api/section")
public class SectionController {

    @Qualifier("sectionService")
    @Autowired
    private ICrudService<Section> service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Section>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Section> get(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.service.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public ResponseEntity<Section> create(@PathVariable("id") String id, @RequestBody Section entity) {
        return new ResponseEntity<>(this.service.create(id, entity), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Section> update(@PathVariable("id") String id, @RequestBody Section entity) {
        return new ResponseEntity<>(this.service.update(id, entity), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Section> delete(@PathVariable("id") String id) {
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}