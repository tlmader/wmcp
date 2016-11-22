package csci4125.application.controller;

import csci4125.application.service.INativeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Defines the REST API for native SQL query usage.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@RequestMapping("api/nativequery")
@RestController
public class NativeQueryController {

    @Autowired
    INativeQueryService service;

    /**
     * Gets results based on a native SQL query.
     *
     * @param query a SQL query
     * @return the Response containing the results.
     */
    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public ResponseEntity<List<List<Object>>> getResults(@RequestBody String query, @RequestParam Map<String, String> vars) {
        return new ResponseEntity<>(this.service.getNativeResults(query, vars), HttpStatus.OK);
    }

    /**
     * Gets results with expected attributes based on a native SQL query.
     *
     * @param query a SQL query
     * @return the Response containing the results with JSON attributes.
     */
    @RequestMapping(value = {"/{attrs}"}, method = RequestMethod.POST)
    public ResponseEntity<List<Map<String, Object>>> getResultsWithAtributes(@RequestBody String query, @PathVariable("attrs") String attrs, @RequestParam Map<String, String> vars) {
        return new ResponseEntity<>(this.service.getNativeResultsWithAttrs(query, vars, attrs), HttpStatus.OK);
    }
}
