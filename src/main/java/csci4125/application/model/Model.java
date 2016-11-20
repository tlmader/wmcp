package csci4125.application.model;

import javax.persistence.MappedSuperclass;

/**
 * Contains the methods and fields for Model entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */

@MappedSuperclass
public abstract class Model {

    public abstract String getId();

    public abstract void setId(String id);
}
