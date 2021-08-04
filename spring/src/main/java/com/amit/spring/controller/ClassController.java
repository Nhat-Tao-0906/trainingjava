package com.amit.spring.controller;

import java.util.List;

import com.amit.spring.model.Class;
import com.amit.spring.model.Student;
import com.amit.spring.model.request.AddClassRequest;
import com.amit.spring.model.response.BaseResponse;
import com.amit.spring.model.utils.ApiException;
import com.amit.spring.service.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @GetMapping("/get-all-class")
    public BaseResponse<List<Class>> getAllClass() throws ApiException {
        return classService.getAllClass();
    }

    @PostMapping("/create-class")
    public BaseResponse<String> createdClass(@RequestBody AddClassRequest request) throws ApiException {
        return classService.createdClass(request);
    }

    @GetMapping("/find-by-name/{name}")
    public BaseResponse<Class> findByName(@PathVariable String name) throws ApiException {
        return classService.findByName(name);
    }

    @GetMapping("/find-by-id/{id}")
    public BaseResponse<Class> findById(@PathVariable Integer id) throws ApiException {
        return classService.findById(id);
    }

    @PostMapping("/delete/{id}")
    public BaseResponse<String> delete(@PathVariable Integer id) throws ApiException {
        return classService.delete(id);
    }

    @PutMapping("/update/{id}")
    public BaseResponse<String> update(@PathVariable Integer id, @RequestBody AddClassRequest request)
            throws ApiException {
        return classService.update(id, request);
    }

    @GetMapping("/get-student/{id}")
    public BaseResponse<List<Student>> getListStudent(@PathVariable Integer id) throws ApiException {
        return classService.getListStudent(id);
    }
}
