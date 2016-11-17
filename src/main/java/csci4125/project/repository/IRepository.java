package csci4125.project.repository;

import java.util.List;

/**
 * Defines methods for a data access layer for communication with the DataSource.
 *
 * @param <T>
 * @author tedmader
 * @since 2016-11-16
 */
public interface IRepository<T> {

    /**
     * Finds and returns all <T> from the database.
     *
     * @return the list of <T> currently in the database
     */
    List<T> getAll();

    /**
     * Returns a specific <T> from the database by a UUID.
     *
     * @param id a UUID for a <T>
     * @return the <T> found by the specified UUID
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
     * Deletes a specific <T> in the database by a UUID.
     *
     * @param id a UUID for a <T>
     */
    void delete(String id);
}
