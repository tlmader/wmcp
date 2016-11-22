package csci4125.application.repository.impl;

import csci4125.application.repository.INativeQueryRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implements data access methods for the usage of native queries.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
@Component
public class NativeQueryRepository implements INativeQueryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Object[]> get(String query, Map<String, String> vars) {
        List results = prepareSQLQuery(query, vars).list();
        if (results.isEmpty()) {
            return null;
        } else if (results.get(0) instanceof String) {
            return convertResultsToObjectArrays(results);
        }
        return results;
    }

    /**
     * Sets each parameter in the given query to its corresponding value and returns the mapped SQL query.
     *
     * @param query a SQL query
     * @return the mapped query
     */
    private Query prepareSQLQuery(String query, Map<String, String> vars) {
        Query sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(query);
        for (Map.Entry<String, String> var : vars.entrySet()) {
            sqlQuery = sqlQuery.setParameter(var.getKey(), var.getValue());
        }
        return sqlQuery;
    }

    /**
     * Converts results to List<Object[]> when Hibernate returns single-column results as List<String>.
     *
     * @param results a results List
     * @return the List of results with type Object[]
     */
    private List<Object[]> convertResultsToObjectArrays(List<String> results) {
        return results.stream().map(x -> new Object[]{x}).collect(Collectors.toList());
    }
}
