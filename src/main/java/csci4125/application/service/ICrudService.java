package csci4125.application.service;

import java.util.List;

/**
 * Defines methods for handling orchestration of workflows and performing calls to engines and resource accessors.
 *
 * @param <T>
 * @author tlmader.dev@gmail.com
 * @since 2016-11-20
 */
public interface ICrudService<T> {

    /**
     * Return all <T> entities.
     *
     * @return the list of <T>
     */
    List<T> getAll();

    /**
     * Returns a specific <T> by an ID.
     *
     * @param id an ID for a <T>
     * @return the <T> found by the ID
     */
    T get(String id);

    /**
     * Creates the existing <T>.
     *
     * @param entity a <T> to be created
     * @return the created <T>
     */
    T create(T entity);

    /**
     * Updates a new <T>.
     *
     * @param entity a <T> to be updated
     * @return the updated <T>
     */
    T update(T entity);

    /**
     * Deletes a specific <T> by an ID.
     *
     * @param id an ID for a <T>
     */
    void delete(String id);

    /**
     * Determines whether or not the given <T> is set to be updated or inserted, and is called by the controller to
     * determine the status code.
     *
     * @param entity a <T> to be upserted
     * @return true if insert <T> or false if update <T>
     */
    boolean upsertIsInsert(T entity);
}