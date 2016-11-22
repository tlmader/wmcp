package csci4125.application.service.impl;

import csci4125.application.model.Skill;
import csci4125.application.repository.ICrudRepository;
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
