package wmcp.api.service.impl;

import wmcp.api.model.Specialty;
import wmcp.api.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements manager workflow methods for Specialty entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class SpecialtyService extends CrudService<Specialty> {

    @Autowired
    public SpecialtyService(ICrudRepository<Specialty> repository) {
        super(repository);
    }
}
