package dat;

import dat.config.HibernateConfig;
import dat.dao.CourseDAO;
import dat.dao.StudentDAO;
import dat.entities.Course;
import dat.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

//        PersonDAO personDAO = new PersonDAO();
//        Person person = new Person("John", 23);
//        personDAO.createPerson(person);
//
//        Query q = em.createQuery("select p from Person p");
//        System.out.println("First person" + q.getSingleResult());

        StudentDAO studentDAO = new StudentDAO();
        Student student1 = new Student("Karl", "Hansen", 99009900, "karlhansen@gmail.com", "Lyngevej 16", true, LocalDate.of(2000, 10, 19),1);
        Student student2 = new Student("Kar", "Hans", 99009920, "karhans@gmail.com", "Lyngevej 1", true, LocalDate.of(2000, 4, 15),2);
        Student student3 = new Student("Ka", "Han", 99009120, "kahan@gmail.com", "Lyngevej 12", true, LocalDate.of(2000, 4, 12),2);

//        studentDAO.createStudent(student1);
//        studentDAO.createStudent(student2);
//        studentDAO.createStudent(student3);

        List<Student> students = studentDAO.getAllStudents();
        System.out.println("All Students in Database: " + students);

        CourseDAO courseDAO = new CourseDAO();
        Course course1 = new Course("Java", 2025, "CL 3.4", LocalDate.of(2025, 5,2), "Jon");
        Course course2 = new Course("Java 2.0", 2023, "CL 3.5", LocalDate.of(2023, 5,2), "Signe");

//        courseDAO.createCourse(course1);
//        courseDAO.createCourse(course2);

        List<Course> courses = courseDAO.getAllCourses();
        System.out.println("All courses: " + courses);

//        student1.setLastName("Karl");
//        studentDAO.updateStudent(student1);

//        course1.setTeacherName("bum");
//        courseDAO.updateCourse(course1);


        int studentId = student1.getCourseId();
        List<Course> studentCourses = studentDAO.getAllCoursesForSpecificStudent(2);

        System.out.println("Courses for Student ID " + studentId + ": " + studentCourses);
    }
}