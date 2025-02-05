package dat.dao;

import dat.config.HibernateConfig;
import dat.entities.Course;
import dat.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDAO {

    public void createCourse(Course course){
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    public void updateCourse(Course course){
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

    public void deleteCourse(Course course){
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
    }

    public List<Course> getAllCourses(){
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        List<Course> courses = em.createQuery("from Course", Course.class).getResultList();
        for(Course course : courses){
            System.out.println("All courses" + "\n" + course);
        }
        return courses;
    }

    public List<Student> getAllStudentsForSpecificCourse(int courseId){
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Student> students = em.createQuery("select s from Student s where s.courseId = :course", Student.class);
        students.setParameter("course", courseId);

        List<Student> studentList = students.getResultList();

        List<Student> filteredCourses = studentList.stream()
                .filter(student -> student.getCourseId() == courseId)
                .filter(course -> course.getId() == courseId)
                .collect(Collectors.toList());
        em.close();
        return filteredCourses;
    }
}
