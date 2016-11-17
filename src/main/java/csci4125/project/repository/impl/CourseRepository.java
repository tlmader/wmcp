package csci4125.project.repository.impl;

import csci4125.project.model.Course;
import org.springframework.stereotype.Component;

/**
 * Implements data access methods for Course entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Component
public class CourseRepository extends Repository<Course> {

    public CourseRepository() {
        super((x, y) -> {
            x.setDescription(y.getDescription());
            x.setStatus(y.getStatus());
            x.setPrice(y.getPrice());
        }, Course.class);
    }
}
