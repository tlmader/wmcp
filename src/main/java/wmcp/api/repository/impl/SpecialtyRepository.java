package wmcp.api.repository.impl;

import wmcp.api.model.Specialty;
import org.springframework.stereotype.Component;

/**
 * Implements data access methods for Object entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Component
public class SpecialtyRepository extends CrudRepository<Specialty> {

    public SpecialtyRepository() {
        super((x, y) -> {
            x.setTitle(y.getTitle());
        }, Specialty.class);
    }
}
