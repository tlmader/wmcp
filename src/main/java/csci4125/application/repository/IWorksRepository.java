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
     * Returns a specific Works by a Person ID and Job ID.
     * @param personId an ID for a Person
     * @param jobsId an ID for a Job
     * @return the Works entity
     */
    Works get(String personId, String jobsId);

    /**
     * Creates a Works association between a Person and a Job.
     * @param person a Person entity
     * @param job a Job entity
     */
    Works create(Person person, Job job);
}
