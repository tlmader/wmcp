package csci4125.application.service.impl;

import csci4125.application.model.Course;
import csci4125.application.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements manager workflow methods for Course entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class CourseService extends CrudService<Course> {

    @Autowired
    public CourseService(ICrudRepository<Course> repository) {
        super(repository);
    }
}
