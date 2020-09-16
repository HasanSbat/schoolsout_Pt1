package data;

import model.Course;
import model.Exam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class ExamRepository {
    public void create(Exam exam) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
        em.close();
    }
    public Optional<Exam> retrieve(Integer id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        Exam foundExam = em.find(Exam.class,id);
        em.close();
        return Optional.ofNullable(foundExam);
    }

    public void update(Exam exam){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        Exam examUpdate = em.find(Exam.class, exam.getId());
        if (examUpdate !=null){
            examUpdate.setName(examUpdate.getName());
            examUpdate.setDate(examUpdate.getDate());
            examUpdate.setDescription(examUpdate.getDescription());
            examUpdate.setTotal(examUpdate.getTotal());
            examUpdate.setWeight(examUpdate.getWeight());
            examUpdate.setModule(examUpdate.getModule());

            em.getTransaction().begin();
            em.merge(examUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("exam is successfully updated");
        }else{
            System.out.println("exam is not updated");
        }
    }

    public void delete(Exam exam){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Exam examExist = em.find(Exam.class, exam.getId());

        if (examExist.isPresent()){
            em.remove(examExist);
            em.getTransaction().commit();
            em.close();
            System.out.println("exam is successfully deleted");

        }else { System.out.println("This exam doesn't find in DB");
        }
    }
}
