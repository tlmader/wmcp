package csci4125.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Contains the methods and fields for Company entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-21
 */
@Entity
@JsonIgnoreProperties({"jobs"})
public class Company extends BaseEntity {

    @Id
    @Column(name = "comp_id")
    private String id;
    @Column(name = "comp_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "primary_sector")
    private String primarySector;
    @Column(name = "website")
    private String website;
    @JsonProperty("jobs")
    @OneToMany
    @JoinColumn(name = "comp_id")
    private List<Job> jobs;

    public Company() {

    }

    public Company(String id, String name, String address, String primarySector, String website) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.primarySector = primarySector;
        this.website = website;
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

    public String getPrimarySector() {
        return primarySector;
    }

    public void setPrimarySector(String primarySector) {
        this.primarySector = primarySector;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != null ? !id.equals(company.id) : company.id != null) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (address != null ? !address.equals(company.address) : company.address != null) return false;
        if (primarySector != null ? !primarySector.equals(company.primarySector) : company.primarySector != null)
            return false;
        return website != null ? website.equals(company.website) : company.website == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (primarySector != null ? primarySector.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }
}
