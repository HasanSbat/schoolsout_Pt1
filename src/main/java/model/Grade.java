package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Grade {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Exam exam;

    private BigDecimal gradeValue;

    private String comment;

    private String internalComment;

    private boolean absent;

    private  boolean postponed;

    private LocalDate date;

    public long getId() {
        return id;
    }

    public Grade setId(long id) {
        this.id = id;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Grade setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Exam getExam() {
        return exam;
    }

    public Grade setExam(Exam exam) {
        this.exam = exam;
        return this;
    }

    public BigDecimal getGradeValue() {
        return gradeValue;
    }

    public Grade setGradeValue(BigDecimal gradeValue) {
        this.gradeValue = gradeValue;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Grade setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getInternalComment() {
        return internalComment;
    }

    public Grade setInternalComment(String internalComment) {
        this.internalComment = internalComment;
        return this;
    }

    public boolean isAbsent() {
        return absent;
    }

    public Grade setAbsent(boolean absent) {
        this.absent = absent;
        return this;
    }

    public boolean isPostponed() {
        return postponed;
    }

    public Grade setPostponed(boolean postponed) {
        this.postponed = postponed;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Grade setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public boolean isPresent() {
        return  true;
    }

}
