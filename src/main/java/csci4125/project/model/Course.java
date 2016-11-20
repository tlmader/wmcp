package csci4125.project.model;

import javax.persistence.*;
import java.util.Currency;

/**
 * Contains the methods and fields for Course entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Entity
public class Course extends Model {

    @Id
    @Column(name = "c_code")
    private String id;
    @Column(name = "c_title")
    private String title;
    @Column(name = "c_level")
    private String level;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "retail_price")
    private Currency price;

    public Course() {

    }

    public Course(String id, String title, String level, String description, String status, Currency price) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.description = description;
        this.status = status;
        this.price = price;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Currency getPrice() {
        return price;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != null ? !id.equals(course.id) : course.id != null) return false;
        if (title != null ? !title.equals(course.title) : course.title != null) return false;
        if (level != null ? !level.equals(course.level) : course.level != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (status != null ? !status.equals(course.status) : course.status != null) return false;
        return price != null ? price.equals(course.price) : course.price == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
