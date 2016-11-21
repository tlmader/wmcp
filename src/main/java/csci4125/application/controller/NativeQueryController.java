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
@RequestMapping("api/query/")
@RestController
public class NativeQueryController {

    @Autowired
    INativeQueryService service;

    /**
     * Gets results based on a native SQL query.
     *
     * @param query a native query
     * @return the Response containing the results.
     */
    @RequestMapping(value = {"nativeresults"}, method = RequestMethod.POST)
    public ResponseEntity<List<List<Object>>> getNativeResults(@RequestBody String query, @RequestHeader Map<String, String> vars) {
        return new ResponseEntity<>(this.service.getNativeResults(query, vars), HttpStatus.OK);
    }

    /**
     * Gets results with attributes based on a native SQL query.
     *
     * @param query a native query
     * @return the Response containing the results with attributes.
     */
    @RequestMapping(value = {"nativeresults/attrs"}, method = RequestMethod.POST)
    public ResponseEntity<List<Map<String, Object>>> getNativeResultsWithAtributes(@RequestBody String query, @RequestHeader Map<String, String> vars, @RequestParam("attrs") String[] attrs) {
        return new ResponseEntity<>(this.service.getNativeResultsWithAttrs(query, vars, attrs), HttpStatus.OK);
    }
}
