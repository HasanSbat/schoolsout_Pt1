package data;

import model.Exam;
import model.Grade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class GradeRepository {
    public void create(Grade grade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(grade);
        em.getTransaction().commit();
        em.close();
    }
    public Optional<Grade> retrieve(Integer id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        Grade foundGrade = em.find(Grade.class,id);
        em.close();
        return Optional.ofNullable(foundGrade);
    }

    public void update(Grade grade){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        Grade gradeUpdate = em.find(Grade.class,grade.getId());
        if (gradeUpdate !=null){
            gradeUpdate.setAbsent(grade.isAbsent());
            gradeUpdate.setGradeValue(grade.getGradeValue());
            //gradeUpdate.getExam(grade.getExam());
            gradeUpdate.setInternalComment(grade.getInternalComment());
            gradeUpdate.setPerson(grade.getPerson());
            gradeUpdate.setPostponed(grade.isPostponed());
            gradeUpdate.setComment(grade.getComment());
            gradeUpdate.setDate(grade.getDate());

            em.getTransaction().begin();
            em.merge(gradeUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("grade is successfully updated");
        }else{
            System.out.println("grade is not updated");
        }
    }

    public void delete(Grade grade){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Grade gradeExist = em.find(Grade.class,grade.getId());

        if (gradeExist.isPresent()){
            em.remove(gradeExist);
            em.getTransaction().commit();
            em.close();
            System.out.println("grade is successfully deleted");

        }else { System.out.println("This grade doesn't find in DB");
        }
    }
}

