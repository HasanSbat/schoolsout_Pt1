package data;

import model.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class PersonRepository {
    public void create(Person person) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public Optional <Person> retrieve(Integer id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        Person foundPerson = em.find(Person.class,id);
        em.close();
        return Optional.ofNullable(foundPerson);
    }

    public void update(Person person){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        Person personUpdate = em.find(Person.class, person.getId());
        if (personUpdate !=null){
            personUpdate.setFirstname(person.getFirstname());
            personUpdate.setFamilyname(person.getFamilyname());
            personUpdate.setGender(person.getGender());
            personUpdate.setCourse(person.getCourse());

            em.getTransaction().begin();
            em.merge(personUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("person is successfully updated");
        }else{
            System.out.println("person is not updated");
        }
    }

    public void delete(Person person){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person personExist = em.find(Person.class, person.getId()) ;

      if (personExist.isPresent()){
          em.remove(personExist);
          em.getTransaction().commit();
          em.close();
          System.out.println("person is successfully deleted");

      }else { System.out.println("This person doesn't find in DB");
      }
    }
}