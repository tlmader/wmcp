package csci4125.application.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-16
 */
public interface ICustomQueryService {

    /**
     * Returns an unmapped body of data by a native query.
     *
     * @param query a native query
     * @return the List of data returned by the query
     */
    List<List<Object>> getNativeResults(String query);
}
