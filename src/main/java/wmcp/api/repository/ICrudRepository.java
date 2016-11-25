package wmcp.api.repository;

import org.hibernate.Session;

import java.util.List;

/**
 * Defines methods for a data access layer for communication with the DataSource.
 *
 * @param <T>
 * @author tlmader.dev@gmail.com
 * @since 2016-11-16
 */
public interface ICrudRepository<T> {

    /**
     * Returns all <T> from the database.
     *
     * @return the list of <T> currently in the database
     */
    List<T> getAll();

    /**
     * Returns a specific <T> from the database by an ID.
     *
     * @param id an ID for a <T>
     * @return the <T> found by the specified ID
     */
    T get(String id);

    /**
     * Creates a <T> and adds it to the database.
     *
     * @param entity a <T> to be added
     * @return the created <T>
     */
    T create(T entity);

    /**
     * Updates a specific <T> in the database.
     *
     * @param entity a <T> containing the updated values
     * @return the updated <T>
     */
    T update(T entity);

    /**
     * Deletes a specific <T> in the database by an ID.
     *
     * @param id an ID for a <T>
     */
    void delete(String id);

    /**
     * Returns a Hibernate Session object from the current SessionFactory.
     *
     * @return the Session
     */
    Session getSession();
}
