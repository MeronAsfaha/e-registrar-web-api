package edu.miu.cs425.eregistrarwebapi.controller;

import edu.miu.cs425.eregistrarwebapi.Service.StudentService;
import edu.miu.cs425.eregistrarwebapi.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eregistrar/api/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        try {
            var student = studentService.getStudentById(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        var savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student){
        try{
            student.setStudentId(id);
            var updatedStudent = studentService.updateStudent(student);
            return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }
}
