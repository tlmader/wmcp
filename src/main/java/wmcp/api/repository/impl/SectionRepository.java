package wmcp.api.repository.impl;

import org.springframework.stereotype.Component;
import wmcp.api.model.Section;

/**
 * Implements data access methods for Section entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Component
public class SectionRepository extends CrudRepository<Section> {

    public SectionRepository() {
        super((x, y) -> {
            x.setSectionYear(y.getSectionYear());
            x.setCompleteDate(y.getCompleteDate());
            x.setOfferedBy(y.getOfferedBy());
            x.setFormat(y.getFormat());
            x.setPrice(y.getPrice());
        }, Section.class);
    }
}
