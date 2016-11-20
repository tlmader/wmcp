package csci4125.application.controller;

import csci4125.application.service.ICustomQueryService;
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
public class CustomQueryController {

    @Autowired
    ICustomQueryService service;

    /**
     * Gets results based on a native SQL query.
     *
     * @param query a native SQL query
     * @return the Response containing the results.
     */
    @RequestMapping(value = {"nativeresults"}, method = RequestMethod.POST)
    public ResponseEntity<List<List<Object>>> getNativeResultsForColumn(@RequestBody String query, @RequestHeader Map<String, String> vars) {
        return new ResponseEntity<>(this.service.getNativeResults(query, vars), HttpStatus.OK);
    }
}
