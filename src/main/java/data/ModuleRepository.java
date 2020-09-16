package data;

import model.Person;
import model.Module;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class ModuleRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
    EntityManager em = emf.createEntityManager();

    public void saveModule(Module module){
        em.getTransaction().begin();
        if(module.getId() == null){
            em.persist(module);
        }else{
            em.merge(module);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Optional<Module> retrieve(Integer id){
        Module foundModule = em.find(Module.class,id);
        em.close();
        return Optional.ofNullable(foundModule);
    }

    public void delete (Module module){
        Module moduleExist = em.find(Module.class, module.getId());
        if ( moduleExist != null) {
            em.getTransaction().begin();
            em.remove(moduleExist);
            em.getTransaction().commit();
            em.close();
            System.out.println("Module is successfully deleted");
        }else{
            System.out.println("This module doesn't find in DB");

        }

    }


    }
