package view1;

import data.*;
import model.*;
import model.Module;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Main1 {
    public static void main(String[] args) {

        CourseRepository courseRepository = new CourseRepository();
        ExamRepository examRepository = new ExamRepository();
        ModuleRepository moduleRepository = new ModuleRepository();
        PersonRepository personRepository = new PersonRepository();
        UserRepository userRepository = new UserRepository();
        GradeRepository gradeRepository = new GradeRepository();


        Course course = new Course();
        course.setActive(true);
        course.setCode("AA12");
        course.setDescription("java Developer");
        course.setName("Java EE");
        courseRepository.create(course);
        //---------------------------------------------------------------//
        Module module = new Module();
        module.setName("SQL");
        module.setDescription("mySql for Java Developer");
        module.setCourse(course);
        moduleRepository.saveModule(module);


        //---------------------------------------------------------------//
        Exam exam = new Exam();
        exam.setModule(module);
        exam.setWeight(12);
        exam.setTotal(95);
        exam.setDescription("very good");
        exam.setName("Chapter 1");
        Exam examgroup = new Exam();
        examgroup.setId(62L);
        exam.setExamGroup(examgroup);
        examRepository.create(exam);
        //---------------------------------------------------------------//
        Person person = new Person();
        person.setFirstname("Lilia");
        person.setFamilyname("Hora");
        person.setGender(Gender.FEMALE);
        person.setCourse(course);
        personRepository.create(person);
        //---------------------------------------------------------------//
        User user = new User();
        user.setLogin("hasan.s");
        user.setPasswordhash("123ABC");
        user.setActive(true);
        Person person1 = new Person();
        person1.setId(37);
        user.setPerson(person1);
       // userRepository.create(user);

        //---------------------------------------------------------------//
        Grade grade = new Grade();
        grade.setExam(exam);
        grade.setGradeValue(BigDecimal.valueOf(12));
        grade.setDate(LocalDate.of(2018,05,02));
        grade.setPerson(person);
        grade.setComment("very goooooooood");
        grade.setInternalComment("He is professional");
        grade.setPostponed(false);
        gradeRepository.create(grade);
    }
}

