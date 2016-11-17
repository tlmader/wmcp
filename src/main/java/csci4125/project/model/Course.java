package csci4125.project.model;

import java.util.Currency;

/**
 * Contains the methods and fields for Course entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
public class Course extends Model {

    private String title;
    private String description;
    private String status;
    private Currency price;

    public Course() {

    }

    public Course(String id, String title, String description, String status, Currency price) {
        super(id, "c_code");
        this.title = title;
        this.description = description;
        this.status = status;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
