package dat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private String address;
    private boolean status;
    private LocalDate dateOfBirth;
    private int courseId;

    public Student (String firstName, String lastName, int phoneNumber, String email, String address, boolean status, LocalDate dateOfBirth, int courseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.courseId = courseId;
    }
}
