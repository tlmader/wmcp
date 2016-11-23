package csci4125.api.repository.impl;

import csci4125.api.model.Skill;
import org.springframework.stereotype.Component;

/**
 * Implements data access methods for Skill entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Component
public class SkillRepository extends CrudRepository<Skill> {

    public SkillRepository() {
        super((x, y) -> {
            x.setTitle(y.getTitle());
            x.setDescription(y.getDescription());
            x.setLevel(y.getLevel());
        }, Skill.class);
    }
}
