package wmcp.api.model;

import java.io.Serializable;

/**
 * Contains the methods and fields for the IdClass for Works entities.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorksId)) return false;

        WorksId worksId = (WorksId) o;

        if (personId != null ? !personId.equals(worksId.personId) : worksId.personId != null) return false;
        return jobId != null ? jobId.equals(worksId.jobId) : worksId.jobId == null;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        return result;
    }
}
