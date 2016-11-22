package csci4125.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Contains the methods and fields for Works entities, used to associate Persons with Jobs.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/21/2016
 */
@Entity
@Table(name = "works")
@IdClass(WorksId.class)
public class Works implements Serializable {

    @Id
    @Column(name = "per_id")
    private String personId;
    @Id
    @Column(name = "job_code")
    private String jobId;
    @Column(name = "start_date")
    private LocalDate start;
    @Column(name = "end_date")
    private LocalDate end;

    public Works() {

    }

    public Works(String personId, String jobId) {
        this.personId = personId;
        this.jobId = jobId;
        this.start = LocalDate.now();
    }
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}