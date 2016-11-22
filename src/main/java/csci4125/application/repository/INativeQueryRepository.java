package csci4125.application.repository;

import java.util.List;
import java.util.Map;

/**
 * Defines methods for a data access layer that takes native queries for communication with the DataSource.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-16
 */
public interface INativeQueryRepository {

    /**
     * Returns a generic body of data from the database by a native query.
     *
     * @param query a native query
     * @param vars a map of query variables
     * @return the List of data returned by the query
     */
    List<Object[]> get(String query, Map<String, String> vars);
}
