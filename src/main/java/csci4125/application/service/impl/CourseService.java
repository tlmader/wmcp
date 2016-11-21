package csci4125.application.service.impl;

import csci4125.application.model.Course;
import csci4125.application.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
public class CourseService extends CrudService<Course> {

    @Autowired
    public CourseService(ICrudRepository<Course> repository) {
        super(repository);
    }
}
