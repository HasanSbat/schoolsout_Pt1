package data;

import model.Person;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class UserRepository {
    public void create(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public Optional<User> retrieve(Integer identity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        User foundUser = em.find(User.class, identity);
        em.close();
        return Optional.ofNullable(foundUser);
    }

    public void update(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        User userUpdate = em.find(User.class, user.getLogin());
        if (userUpdate != null) {
            userUpdate.setActive(user.isActive());
            userUpdate.setPasswordhash(user.getPasswordhash());
            em.getTransaction().begin();
            em.merge(userUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("user is successfully updated");
        } else {
            System.out.println("user is not updated");
        }
    }

    public void delete(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User userExist = em.find(User.class, user.getLogin());

        if (userExist.isPresent()) {
            em.remove(userExist);
            em.getTransaction().commit();
            em.close();
            System.out.println("user is successfully deleted");

        } else {
            System.out.println("This user doesn't find in DB");
        }
    }
}