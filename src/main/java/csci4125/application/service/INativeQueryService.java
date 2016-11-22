package csci4125.application.service;

import java.util.List;
import java.util.Map;

/**
 * Implements service workflow methods for native SQL query usage.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-16
 */
public interface INativeQueryService {

    /**
     * Returns an unmapped body of data by a native query.
     *
     * @param query a SQL query
     * @param vars a map of query variables
     * @return the List of results
     */
    List<List<Object>> getNativeResults(String query, Map<String, String> vars);

    /**
     * Returns an unmapped body of data by a native query.
     *
     * @param query a native query
     * @param vars a map of query variables
     * @param attrs an array of JSON attributes
     * @return the List of results with JSON attributes
     */
    List<Map<String, Object>> getNativeResultsWithAttrs(String query, Map<String, String> vars, String attrs);
}
