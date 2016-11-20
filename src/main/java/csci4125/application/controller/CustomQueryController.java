package csci4125.application.controller;

import csci4125.application.service.ICustomQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@RequestMapping("api/query/")
@RestController
public class CustomQueryController {

    @Autowired
    ICustomQueryService service;

    @RequestMapping(value = {"nativeresults"}, method = RequestMethod.POST)
    public ResponseEntity<List<Object[]>> getNativeResults(@RequestBody String query) {
        return new ResponseEntity<>(this.service.getNativeResults(query), HttpStatus.OK);
    }
}
