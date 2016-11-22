package csci4125.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Contains the methods and fields for Skill entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-21
 */
@Entity
@Table(name = "knowledge_skill")
@JsonIgnoreProperties({"jobProfiles", "persons"})
public class Skill extends BaseEntity {

    @Id
    @Column(name = "ks_code")
    private String id;
    @Column(name = "ks_title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "s_level")
    private String level;
    @JsonProperty("jobProfiles")
    @ManyToMany(mappedBy = "requiredSkills")
    private List<JobProfile> jobProfiles;
    @JsonProperty("persons")
    @ManyToMany(mappedBy = "knownSkills")
    private List<Person> persons;

    public Skill() {

    }

    public Skill(String id, String title, String description, String level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<JobProfile> getJobProfiles() {
        return jobProfiles;
    }

    public void setJobProfiles(List<JobProfile> jobProfiles) {
        this.jobProfiles = jobProfiles;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (id != null ? !id.equals(skill.id) : skill.id != null) return false;
        if (title != null ? !title.equals(skill.title) : skill.title != null) return false;
        if (description != null ? !description.equals(skill.description) : skill.description != null) return false;
        return level != null ? level.equals(skill.level) : skill.level == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }
}
