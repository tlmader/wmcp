package csci4125.api.model;

import javax.persistence.MappedSuperclass;

/**
 * Contains the methods and fields for BaseEntity entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */

@MappedSuperclass
public abstract class BaseEntity {

    public abstract String getId();

    public abstract void setId(String id);
}
