package csci4125.project.model;

/**
 * Contains the methods and fields for Model entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */

public class Model {

    private String id;

    public Model() {

    }

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
