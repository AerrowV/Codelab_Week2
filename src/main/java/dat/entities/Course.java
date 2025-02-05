package dat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int semesterYear;
    private String classroom;
    private LocalDate courseDate;
    private String teacherName;

    public Course(String courseName, int semesterYear, String classroom, LocalDate courseDate, String teacherName) {
        this.courseName = courseName;
        this.semesterYear = semesterYear;
        this.classroom = classroom;
        this.courseDate = courseDate;
        this.teacherName = teacherName;
    }
}
