package csci4125.application.service;

import csci4125.application.model.Course;
import csci4125.application.model.Job;

import java.util.List;

/**
 * Defines methods for handling orchestration of career planning workflows and performing calls to repositories.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
public interface ICareerPlanningService {

    /**
     * Finds Jobs by a specific primary sector.
     *
     * @param primarySector a String for a primary sector
     * @return the List of Jobs
     */
    List<Job> findJobsByPrimarySector(String primarySector);

    /**
     * Finds a Courses required for a Job Profile based on required skills and known skills (optional) and returns a
     * List containing the minimum number of Courses teaching the least unneeded skills.
     *
     * @param jobProfileId
     * @param personId
     * @return
     */
    List<Course> findCoursesForJobProfile(String jobProfileId, String personId);
}
