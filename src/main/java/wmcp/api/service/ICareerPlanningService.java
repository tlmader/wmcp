package wmcp.api.service;

import wmcp.api.model.Course;
import wmcp.api.model.Job;
import wmcp.api.model.Person;

import java.util.List;

/**
 * Defines methods for handling orchestration of career planning workflows and performing calls to repositories.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
public interface ICareerPlanningService {

    /**
     * Adds a Person with a List of known Skills based on completed Sections.
     *
     * @param id an ID for a Person
     * @param person a Person with Sections
     * @return the added Person
     */
    Person addPersonWithQualifications(String id, Person person);

    /**
     * Finds Jobs by a specific primary sector.
     *
     * @param primarySector a String for a primary sector
     * @return the List of Jobs
     */
    List<Job> findJobsByPrimarySector(String primarySector);

    /**
     * Finds a set of Courses required for a Job Profile based on required skills and known skills (optional) and returns a
     * List containing the minimum number of Courses teaching the least unneeded skills.
     *
     * @param jobProfileId
     * @param personId
     * @return
     */
    List<Course> findCourseSetForJobProfile(String jobProfileId, String personId);
}
