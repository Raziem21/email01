package co.develhope.email01.services;

import co.develhope.email01.entities.Student;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServices {

    List<Student> students = Arrays.asList(
            new Student("1", "Emanuele", "La Mantia", "io.emanuele@hotmail.it"),
            new Student("2", "Davide", "Pigliacelli", "pigliacelli@gmail.com"),
            new Student("3", "Lorenzo", "De Francesco", "nonsicapiscenulladaimieivideo@hotmail.it"),
            new Student("4", "Riccardo", "Riccardini", "riccardone.riccardetto@richi.it")
    );

    public Student getStudentById(String studentId) {
        Optional<Student> studentFromDB = students.stream().filter(student -> Objects.equals(student.getId(), studentId)).findAny();
        if (studentFromDB.isPresent()) return studentFromDB.get();
        return null;
    }
}
