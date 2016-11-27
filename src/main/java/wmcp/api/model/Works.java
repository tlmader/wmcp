package wmcp.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Contains the methods and fields for Works entities used to associate Persons with Jobs.
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
    private Timestamp start;
    @Column(name = "end_date")
    private Timestamp end;

    public Works() {

    }

    public Works(String personId, String jobId) {
        this.personId = personId;
        this.jobId = jobId;
        this.start = new Timestamp(System.currentTimeMillis());
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

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Works)) return false;

        Works works = (Works) o;

        if (personId != null ? !personId.equals(works.personId) : works.personId != null) return false;
        if (jobId != null ? !jobId.equals(works.jobId) : works.jobId != null) return false;
        if (start != null ? !start.equals(works.start) : works.start != null) return false;
        return end != null ? end.equals(works.end) : works.end == null;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}