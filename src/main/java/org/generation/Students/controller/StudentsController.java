package org.generation.Students.controller;

import org.generation.Students.StudentsApplication;
import org.generation.Students.data.entity.Student;
import org.generation.Students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;

@RestController
public class StudentsController {
    private StudentService studentService;

    public StudentsController( @Autowired StudentService studentService )
    {
        this.studentService = studentService;
    }
    @GetMapping("/student")
    public Iterable<Student> getStudents()
    {
        return studentService.all();
    }
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.get(id);
    }
    @PostMapping("/student")
    public void saveStudent(@RequestBody Student student)
    {
        studentService.save(student);
    }
    @PutMapping("/student")
    public void updateStudent(@RequestBody Student student)
    {
        studentService.update(student);
    }
    @DeleteMapping("/student/{id}")
    public Student removeStudent(@PathVariable Integer id)
    {
        return studentService.delete(id);
    }
}
