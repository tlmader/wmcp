package wmcp.api.model;

import java.io.Serializable;

/**
 * Contains the methods and fields for the IdClass for Section entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/26/2016
 */
public class SectionId implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionId)) return false;

        SectionId sectionId1 = (SectionId) o;

        if (sectionId != null ? !sectionId.equals(sectionId1.sectionId) : sectionId1.sectionId != null) return false;
        if (courseId != null ? !courseId.equals(sectionId1.courseId) : sectionId1.courseId != null) return false;
        return sectionYear != null ? sectionYear.equals(sectionId1.sectionYear) : sectionId1.sectionYear == null;
    }

    @Override
    public int hashCode() {
        int result = sectionId != null ? sectionId.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (sectionYear != null ? sectionYear.hashCode() : 0);
        return result;
    }
}
