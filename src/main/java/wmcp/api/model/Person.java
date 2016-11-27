package wmcp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Contains the methods and fields for Person entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-21
 */
@Entity
@Table(name = "person")
@JsonIgnoreProperties({"jobs, takenSections, knownSkills"})
public class Person extends BaseEntity {

    @Id
    @Column(name = "per_id")
    private String id;
    @Column(name = "person_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_num")
    private String phoneNum;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @JsonProperty("jobs")
    @ManyToMany(mappedBy = "persons")
    private List<Job> jobs;
    @JsonProperty("takesSections")
    @ManyToMany
    @JoinTable(
            name = "takes",
            joinColumns = @JoinColumn(name = "per_id"),
            inverseJoinColumns = @JoinColumn(name = "sec_no")
    )
    private List<Section> takesSections;
    @JsonProperty("knownSkills")
    @ManyToMany
    @JoinTable(
            name = "knows",
            joinColumns = @JoinColumn(name = "per_id"),
            inverseJoinColumns = @JoinColumn(name = "ks_code")
    )
    private List<Skill> knownSkills;

    public Person() {

    }

    public Person(String id, String name, String address, String phoneNum, String email, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Skill> getKnownSkills() {
        return knownSkills;
    }

    public void setKnownSkills(List<Skill> knownSkills) {
        this.knownSkills = knownSkills;
    }

    public List<Section> getTakesSections() {
        return takesSections;
    }

    public void setTakesSections(List<Section> takesSections) {
        this.takesSections = takesSections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (address != null ? !address.equals(person.address) : person.address != null) return false;
        if (phoneNum != null ? !phoneNum.equals(person.phoneNum) : person.phoneNum != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (gender != null ? !gender.equals(person.gender) : person.gender != null) return false;
        if (jobs != null ? !jobs.equals(person.jobs) : person.jobs != null) return false;
        if (takesSections != null ? !takesSections.equals(person.takesSections) : person.takesSections != null)
            return false;
        return knownSkills != null ? knownSkills.equals(person.knownSkills) : person.knownSkills == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (jobs != null ? jobs.hashCode() : 0);
        result = 31 * result + (takesSections != null ? takesSections.hashCode() : 0);
        result = 31 * result + (knownSkills != null ? knownSkills.hashCode() : 0);
        return result;
    }
}
