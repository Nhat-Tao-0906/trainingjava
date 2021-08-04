package com.amit.spring.controller;

import java.util.List;

import com.amit.spring.model.Student;
import com.amit.spring.model.request.AddStudentRequest;
import com.amit.spring.model.response.BaseResponse;
import com.amit.spring.model.utils.ApiException;
import com.amit.spring.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public BaseResponse<String> createStudent(@RequestBody AddStudentRequest request) throws ApiException {
        return studentService.createdStudent(request);
    }

    @GetMapping("/get-all")
    public BaseResponse<List<Student>> getAll() throws ApiException {
        return studentService.getAllStudent();
    }

    @PostMapping("/delete/{id}")
    public BaseResponse<String> delete(@PathVariable Integer id) throws ApiException {
        return studentService.delete(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse<String> update(@PathVariable Integer id, AddStudentRequest request) throws ApiException {
        return studentService.update(id, request);
    }

    @GetMapping("/find-by-id/{id}")
    public BaseResponse<Student> findById(@PathVariable Integer id) throws ApiException {
        return studentService.findById(id);
    }

    @GetMapping("/find-by-name/{name}")
    public BaseResponse<Student> findByName(@PathVariable String name) throws ApiException {
        return studentService.findByName(name);
    }
}
