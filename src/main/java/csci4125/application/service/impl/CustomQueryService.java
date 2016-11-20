package csci4125.application.service.impl;

import csci4125.application.repository.ICustomQueryRepository;
import csci4125.application.service.ICustomQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Object[]> getNativeResults(String query) {
        return repository.get(query);
    }
}
