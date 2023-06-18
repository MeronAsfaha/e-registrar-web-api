package edu.miu.cs425.eregistrarwebapi.repository;

import edu.miu.cs425.eregistrarwebapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByFirstNameContainingOrLastNameContainingOrStudentNumberContaining(
            String firstName, String lastName, String studentNumber);
}
