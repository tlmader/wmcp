package csci4125.project.repository.impl;

import csci4125.project.model.Course;

/**
 * Description.
 *
 * @author ted.mader@ge.com
 * @since 2016-11-17
 */
public class CourseRepository extends Repository<Course> {

    public CourseRepository() {
        super((x, y) -> {
            x.setDescription(y.getDescription());
            x.setStatus(y.getStatus());
            x.setPrice(y.getPrice());
        }, Course.class);
    }
}
