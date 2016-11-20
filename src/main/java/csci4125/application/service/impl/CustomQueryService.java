package csci4125.application.service.impl;

import csci4125.application.repository.ICustomQueryRepository;
import csci4125.application.service.ICustomQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class CustomQueryService implements ICustomQueryService {

    @Autowired
    ICustomQueryRepository repository;

    @Override
    public List<List<Object>> getNativeResults(String query) {
        return mapNativeResults(repository.get(query));
    }

    private List<List<Object>> mapNativeResults(List<Object[]> results) {
        return results.stream().map(Arrays::asList).collect(Collectors.toList());
    }
}
