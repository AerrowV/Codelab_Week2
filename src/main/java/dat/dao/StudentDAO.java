package dat.dao;

import dat.config.HibernateConfig;
import dat.entities.Course;
import dat.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentDAO {
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    public void createStudent(Student student){
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    public void updateStudent(Student student){
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public void deleteStudent(Student student){
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    public List<Student>getAllStudents(){
        List<Student> students = em.createQuery("from Student", Student.class).getResultList();
        for(Student student : students){
            System.out.println("All students" + "\n" + student);

        }
        return students;
    }

    public List<Course> getAllCoursesForSpecificStudent(int studentId){
        TypedQuery<Course> courses = em.createQuery("SELECT c FROM Course c WHERE c.id = :studentId", Course.class);
        courses.setParameter("studentId", studentId);

        List<Course> courseList = courses.getResultList();

        return courseList;
    }
}
