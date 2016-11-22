package csci4125.application.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Contains the methods and fields for Works entities, used to associate Persons with Jobs.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/21/2016
 */
@Entity
@Table(name = "works")
public class Works {

    @EmbeddedId
    private WorksId id;
    private LocalDate start;
    private LocalDate end;

    public Works(String personId, String jobId) {
        this.id = new WorksId(personId, jobId);
        this.start = LocalDate.now();
    }

    public String getPersonId() {
        return this.id.getPerson();
    }

    public void setPersonId(String personId) {
        this.id.setPerson(personId);
    }

    public String getJobId() {
        return id.getJob();
    }

    public void setJobId(String jobId) {
        this.id.setJob(jobId);
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
