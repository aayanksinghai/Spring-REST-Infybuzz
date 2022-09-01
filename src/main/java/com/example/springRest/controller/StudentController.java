package com.example.springRest.controller;


import com.example.springRest.entity.Student;
import com.example.springRest.repository.StudentRepository;
import com.example.springRest.request.CreateStudentRequest;
import com.example.springRest.request.InQueryRequest;
import com.example.springRest.request.UpdateStudentRequest;
import com.example.springRest.response.StudentResponse;
import com.example.springRest.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentService studentService;




//    @Value("${app.name: Default REST App}")
//    private String appName;
//
//
//    @GetMapping("/get")
//    //@RequestMapping(value = "/get", method = RequestMethod.GET)
//    public String get(){
//        return appName;
////        return "Hello Student";
//    }
//
//    @GetMapping("/getStudents")
//    public StudentResponse getStudent(){
//        StudentResponse studentResponse = new StudentResponse(1, "Aayank", "Singhai");
//        return studentResponse;
//    }

    @RequestMapping("get")
    public String getHello(){
        return "Hello";
    }

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents(){
        List<Student> studentList =  studentService.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    @PostMapping("create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){

        //Student student = studentService.createStudent(createStudentRequest);
        Student student = studentService.createStudent(createStudentRequest);
        return new StudentResponse(student);
    }

    @PutMapping("update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){

        Student student = studentService.updateStudent(updateStudentRequest);
        return new StudentResponse(student);
    }


    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/getByFirstName/{firstName}")
    public List<StudentResponse> getByFirstName(@PathVariable String firstName){
        List<Student> studentList = studentService.getByFirstName(firstName);

        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }


    @GetMapping("/getByFirstNameAndLastName/{firstName}/{lastName}")
    public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
       return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
    }

    @GetMapping("/getByFirstNameOrLastName/{firstName}/{lastName}")
    public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName){
        List<Student> studentList = studentService.getByFirstNameOrLastName(firstName, lastName);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }


    @GetMapping("getByFirstNameIn")
    public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
        List<Student>studentList = studentService.getByFirstNameIn(inQueryRequest);

        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getAllWithPagination")
    public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        List<Student> studentList = studentService.getAllStudentWithPagination(pageNo, pageSize);

        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getAllWithSorting")
    public List<StudentResponse> getAllStudentsWithSorting(){
        List<Student> studentList = studentService.getAllStudentsWithSorting();
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }


    @GetMapping("like/{firstName}")
    public List<StudentResponse> like(@PathVariable String firstName){
        List<Student> studentList = studentService.like(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("startsWith/{firstName}")
    public List<StudentResponse> startsWith(@PathVariable String firstName){
        List<Student> studentList = studentService.startsWith(firstName);

        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @PutMapping("updateFirstName/{id}/{firstName}")
    public String updateStudentWithJpql(@PathVariable Long id, @PathVariable String firstName){
        return studentService.updateStudentWithJpql(id , firstName) + " Student(s) updated!";
    }

    @DeleteMapping("deleteByFirstName/{firstName}")
    public String deleteStudent(@PathVariable String firstName){
        return studentService.deleteStudent(firstName) + " Student(s) deleted";
    }

    @GetMapping("/getByCity/{city}")
    public List<StudentResponse> getByCity(@PathVariable String city){
        List<Student> studentList = studentService.getByCity(city);

        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

}
