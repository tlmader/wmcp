package wmcp.api.model;

import javax.persistence.*;

/**
 * Contains the methods and fields for Section entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/26/2016
 */
@Entity
@Table(name = "section")
@IdClass(SectionId.class)
public class Section {

    @Id
    @Column(name = "c_code")
    private String courseId;
    @Id
    @Column(name = "sec_no")
    private String sectionId;
    @Id
    @Column(name = "sec_year")
    private Integer sectionYear;
    @Column(name = "complete_date")
    private Integer completeDate;
    @Column(name = "offered_by")
    private String offeredBy;
    @Column(name = "sec_format")
    private String format;
    @Column(name = "price")
    private Float price;

    public Section() {

    }

    public Section(String courseId, String sectionId, Integer sectionYear, Integer completeDate, String offeredBy, String format, Float price) {
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.sectionYear = sectionYear;
        this.completeDate = completeDate;
        this.offeredBy = offeredBy;
        this.format = format;
        this.price = price;
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

    public Integer getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Integer completeDate) {
        this.completeDate = completeDate;
    }

    public String getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(String offeredBy) {
        this.offeredBy = offeredBy;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;

        Section section = (Section) o;

        if (courseId != null ? !courseId.equals(section.courseId) : section.courseId != null) return false;
        if (sectionId != null ? !sectionId.equals(section.sectionId) : section.sectionId != null) return false;
        if (sectionYear != null ? !sectionYear.equals(section.sectionYear) : section.sectionYear != null) return false;
        if (completeDate != null ? !completeDate.equals(section.completeDate) : section.completeDate != null)
            return false;
        if (offeredBy != null ? !offeredBy.equals(section.offeredBy) : section.offeredBy != null) return false;
        if (format != null ? !format.equals(section.format) : section.format != null) return false;
        return price != null ? price.equals(section.price) : section.price == null;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (sectionId != null ? sectionId.hashCode() : 0);
        result = 31 * result + (sectionYear != null ? sectionYear.hashCode() : 0);
        result = 31 * result + (completeDate != null ? completeDate.hashCode() : 0);
        result = 31 * result + (offeredBy != null ? offeredBy.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
