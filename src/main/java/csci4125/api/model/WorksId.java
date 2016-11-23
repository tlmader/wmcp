package csci4125.api.model;

import java.io.Serializable;

/**
 * Embeddable class for Works.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/22/2016
 */
public class WorksId implements Serializable {

    private String personId;
    private String jobId;

    public WorksId() {
        
    }

    public WorksId(String personId, String jobId) {
        this.personId = personId;
        this.jobId = jobId;
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
}
