package csci4125.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Contains the methods and fields for Person entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-21
 */
@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (address != null ? !address.equals(person.address) : person.address != null) return false;
        if (phoneNum != null ? !phoneNum.equals(person.phoneNum) : person.phoneNum != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        return gender != null ? gender.equals(person.gender) : person.gender == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
