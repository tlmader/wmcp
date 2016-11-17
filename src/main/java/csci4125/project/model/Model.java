package csci4125.project.model;

/**
 * Contains the methods and fields for Model entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */

public class Model {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        return id != null ? id.equals(model.id) : model.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
