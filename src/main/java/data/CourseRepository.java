package data;

import model.Course;
import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class CourseRepository {
    public void create(Course course) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }
    public Optional<Course> retrieve(Integer id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        Course foundCourse = em.find(Course.class,id);
        em.close();
        return Optional.ofNullable(foundCourse);
    }

    public void update(Course course){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        Course courseUpdate = em.find(Course.class, course.getId());
        if (courseUpdate !=null){
            courseUpdate.setName(courseUpdate.getName());
            courseUpdate.setDescription(courseUpdate.getDescription());
            courseUpdate.setDescription(courseUpdate.getDescription());
            courseUpdate.setCode(courseUpdate.getCode());
            courseUpdate.setImageURl(courseUpdate.getImageURl());
            courseUpdate.setActive(courseUpdate.isActive());
            courseUpdate.setModules(courseUpdate.getModules());
            em.getTransaction().begin();
            em.merge(courseUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("course is successfully updated");
        }else{
            System.out.println("course is not updated");
        }
    }

    public void delete(Course course){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course courseUpdate = em.find(Course.class, course.getId());

        if (courseUpdate.isPresent()){
            em.remove(courseUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("person is successfully deleted");

        }else { System.out.println("This person doesn't find in DB");
        }
    }
}
