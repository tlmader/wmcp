package csci4125.application.repository.impl;

import csci4125.application.repository.INativeQueryRepository;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public List<Object[]> get(String query) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(query);
        List results = sqlQuery.list();
        if (results.isEmpty()) {
            return null;
        } else if (results.get(0) instanceof String) {
            return convertResultsToObjectArrays(results);
        }
        return results;
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
