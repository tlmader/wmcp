package csci4125.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Description.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
@Entity
public class Specialty extends BaseEntity {

    @Id
    @Column(name = "spec_id")
    private String id;
    @Column(name = "spec_title")
    private String title;

    public Specialty() {

    }

    public Specialty(String id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialty specialty = (Specialty) o;

        if (id != null ? !id.equals(specialty.id) : specialty.id != null) return false;
        return title != null ? title.equals(specialty.title) : specialty.title == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
