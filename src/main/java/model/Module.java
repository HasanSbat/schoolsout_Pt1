package model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Module {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Lob
    private String description;

    @ManyToOne(cascade ={CascadeType.MERGE })
    private Course course;

    @OneToMany(mappedBy = "module",
            fetch = FetchType.EAGER,
            targetEntity = Exam.class,
            cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Exam> exams;

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public Module setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Module setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Module setDescription(String description) {
        this.description = description;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Module setCourse(Course course) {
        this.course = course;
        return this;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public Module setExams(List<Exam> exams) {
        this.exams = exams;
        return this;
    }
}

