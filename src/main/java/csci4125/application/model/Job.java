package csci4125.application.model;

import javax.persistence.*;
import java.util.List;

/**
 * Contains the methods and fields for Job entities.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-21
 */
@Entity
public class Job extends BaseEntity {

    @Id
    @Column(name = "job_code")
    private String id;
    @ManyToOne
    @JoinColumn(name = "jp_code")
    private JobProfile jobProfile;
    @ManyToOne
    @JoinColumn(name = "comp_id")
    private Company company;
    @Column(name = "type")
    private String type;
    @Column(name = "pay_rate")
    private Float payRate;
    @Column(name = "pay_type")
    private String payType;
    @ManyToMany
    @JoinTable(
            name = "works",
            joinColumns = @JoinColumn(name = "job_code"),
            inverseJoinColumns = @JoinColumn(name = "per_id")
    )
    private List<Person> persons;

    public Job() {

    }

    public Job(String id, JobProfile jobProfile, Company company, String type, Float payRate, String payType) {
        this.id = id;
        this.jobProfile = jobProfile;
        this.company = company;
        this.type = type;
        this.payRate = payRate;
        this.payType = payType;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public JobProfile getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(JobProfile jobProfile) {
        this.jobProfile = jobProfile;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPayRate() {
        return payRate;
    }

    public void setPayRate(Float payRate) {
        this.payRate = payRate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        if (jobProfile != null ? !jobProfile.equals(job.jobProfile) : job.jobProfile != null) return false;
        if (company != null ? !company.equals(job.company) : job.company != null) return false;
        if (type != null ? !type.equals(job.type) : job.type != null) return false;
        if (payRate != null ? !payRate.equals(job.payRate) : job.payRate != null) return false;
        return payType != null ? payType.equals(job.payType) : job.payType == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (jobProfile != null ? jobProfile.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (payRate != null ? payRate.hashCode() : 0);
        result = 31 * result + (payType != null ? payType.hashCode() : 0);
        return result;
    }
}
