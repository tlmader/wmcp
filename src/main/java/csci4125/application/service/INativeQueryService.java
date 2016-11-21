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
     * @param query a native query
     * @return the List of data returned by the query
     */
    List<List<Object>> getNativeResults(String query, Map<String, String> vars);
}
