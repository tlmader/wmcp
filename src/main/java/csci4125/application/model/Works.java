package csci4125.application.model;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Contains the methods and fields for Works entities, used to associate Persons with Jobs.
 *
 * @author tlmader.dev@gmail.com
 * @since 11/21/2016
 */
@Entity
public class Works {

    private Person person;
    private Job job;
    private LocalDate start;
    private LocalDate end;

    public Works(Person person, Job job) {
        this.person = person;
        this.job = job;
        this.start = LocalDate.now();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
