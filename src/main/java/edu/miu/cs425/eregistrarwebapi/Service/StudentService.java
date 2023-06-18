package edu.miu.cs425.eregistrarwebapi.Service;

import edu.miu.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student newStudent);

    Student updateStudent(Student newStudent);

    void deleteById(Long studentId);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    List<Student> searchStudent(String string);
}
