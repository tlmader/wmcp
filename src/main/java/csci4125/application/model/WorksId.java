package csci4125.application.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Embeddable class for Works.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
@Embeddable
public class WorksId implements Serializable {

    @Column(name = "per_id")
    private String personId;
    @Column(name = "job")
    private String jobId;

    public WorksId(String personId, String jobId) {
        this.personId = personId;
        this.jobId = jobId;
    }

    public String getPerson() {
        return personId;
    }

    public void setPerson(String personId) {
        this.personId = personId;
    }

    public String getJob() {
        return jobId;
    }

    public void setJob(String jobId) {
        this.jobId = jobId;
    }
}
