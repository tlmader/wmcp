package wmcp.api.model;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Contains the methods and fields for the IdClass for Section entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/26/2016
 */
public class SectionId {

    private String sectionId;
    private String courseId;
    private Integer sectionYear;

    public SectionId() {

    }

    public SectionId(String courseId, String sectionId, Integer sectionYear) {
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.sectionYear = sectionYear;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getSectionYear() {
        return sectionYear;
    }

    public void setSectionYear(Integer sectionYear) {
        this.sectionYear = sectionYear;
    }
}
