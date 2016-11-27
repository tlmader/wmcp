package wmcp.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wmcp.api.model.Section;
import wmcp.api.repository.ICrudRepository;

/**
 * Implements manager workflow methods for Section entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class SectionService extends CrudService<Section> {

    @Autowired
    public SectionService(ICrudRepository<Section> repository) {
        super(repository);
    }
}
