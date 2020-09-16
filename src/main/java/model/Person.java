package model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;

    private String firstname;

    private String familyname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Course course;

    @OneToOne
    private User user;

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Person setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getFamilyname() {
        return familyname;
    }

    public Person setFamilyname(String familyname) {
        this.familyname = familyname;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Person setCourse(Course course) {
        this.course = course;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Person setUser(User user) {
        this.user = user;
        return this;
    }


    public boolean isPresent() {
        return true;
    }
}