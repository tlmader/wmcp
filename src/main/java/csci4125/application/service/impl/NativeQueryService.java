package csci4125.application.service.impl;

import csci4125.application.repository.INativeQueryRepository;
import csci4125.application.service.INativeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implements manager workflow methods for native SQL query usage.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class NativeQueryService implements INativeQueryService {

    @Autowired
    INativeQueryRepository repository;

    @Override
    public List<List<Object>> getNativeResults(String query, Map<String, String> vars) {
        return mapNativeResults(repository.get(mapValuesToKeysForQuery(query, vars)));
    }

    @Override
    public List<Map<String, Object>> getNativeResultsWithAttrs(String query, Map<String, String> vars, String[] attrs) {
        return mapNativeResultsToAttrs(attrs, repository.get(mapValuesToKeysForQuery(query, vars)));
    }

    /**
     * Maps result arrays to Lists.
     *
     * @param results a List of Object[]
     * @return the List of Lists.
     */
    private List<List<Object>> mapNativeResults(List<Object[]> results) {
        return results.stream().map(Arrays::asList).collect(Collectors.toList());
    }

    /**
     * Maps each ${key} to its matching value and returns the mapped SQL query.
     *
     * @param query a native query
     * @return the mapped query.
     */
    private String mapValuesToKeysForQuery(String query, Map<String, String> vars) {
        for (Map.Entry<String, String> var : vars.entrySet()) {
            query = query.replace("${" + var.getKey() + "}", var.getValue());
        }
        return query;
    }

    private List<Map<String, Object>> mapNativeResultsToAttrs(String[] attrs, List<Object[]> results) {
        return results.stream().map(r -> IntStream.range(0, r.length).boxed()
                .collect(Collectors.toMap(i -> attrs[i], i -> r[i]))).collect(Collectors.toList());
    }
}
