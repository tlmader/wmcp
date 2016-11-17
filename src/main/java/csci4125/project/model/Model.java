package csci4125.project.model;

import javax.persistence.MappedSuperclass;

/**
 * Contains the methods and fields for Model entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */

@MappedSuperclass
public abstract class Model {

    private String id;

    public Model(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
