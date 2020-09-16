package model;

import com.sun.xml.fastinfoset.util.StringIntMap;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue
    private long id;

    private String name ;
    @Lob
    private String description;

    private String code;

    private String imageURl;

    private boolean active;

    @OneToMany(mappedBy = "course")
    private List<Module> modules;

    public Course() {
    }

    public long getId() {
        return id;
    }

    public Course setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Course setCode(String code) {
        this.code = code;
        return this;
    }

    public String getImageURl() {
        return imageURl;
    }

    public Course setImageURl(String imageURl) {
        this.imageURl = imageURl;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Course setActive(boolean active) {
        this.active = active;
        return this;
    }

    public List<Module> getModules() {
        return modules;
    }

    public Course setModules(List<Module> modules) {
        this.modules = modules;
        return this;
    }

    public boolean isPresent() {
        return true;
    }
}

