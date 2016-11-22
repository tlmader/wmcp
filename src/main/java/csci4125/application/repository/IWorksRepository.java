package csci4125.application.repository;

import csci4125.application.model.Job;
import csci4125.application.model.Person;
import csci4125.application.model.Works;

/**
 * Defines methods for a data access layer for communication with the DataSource for handling Person to Job
 * associations.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
public interface IWorksRepository {

    /**
     * Creates a Works association between a Person and a Job.
     * @param person
     * @param job
     */
    Works create(Person person, Job job);
}
