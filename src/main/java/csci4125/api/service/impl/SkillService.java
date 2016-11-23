package csci4125.api.service.impl;

import csci4125.api.model.Skill;
import csci4125.api.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements service workflow methods for Skill entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/20/2016
 */
@Service
public class SkillService extends CrudService<Skill> {

    @Autowired
    public SkillService(ICrudRepository<Skill> repository) {
        super(repository);
    }
}
