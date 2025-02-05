package dat.dao;

import dat.config.HibernateConfig;
import dat.entities.Person;
import dat.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDAO {

    public void createPerson(Person person) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }
}
