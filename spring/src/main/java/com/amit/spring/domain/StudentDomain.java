package com.amit.spring.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amit.spring.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDomain {

    @Autowired
    ClassDomain classDomain;

    private Map<Integer, Student> cacheById = new HashMap<>();
    private Map<String, Student> cacheByName = new HashMap<>();
    private static int IDD = 0;

    private synchronized int getIDD() {
        IDD++;
        return IDD;
    }

    public Student findById(Integer id) {
        return cacheById.get(id);
    }

    public Student findByName(String name) {
        return cacheByName.get(name);
    }

    public void createdStudent(Integer id, String name) {
        Student newStudent = new Student();
        newStudent.setId(this.getIDD());
        newStudent.setName(name);
        newStudent.setAClass(id);
        classDomain.findById(id).getStudents().add(newStudent);
        classDomain.findByName(classDomain.findById(id).getName()).getStudents().add(newStudent);
        cacheById.put(newStudent.getId(), newStudent);
        cacheByName.put(name, newStudent);
    }

    public List<Student> getAllStudent() {
        return new ArrayList<>(cacheByName.values());
    }

    public void delete(Integer id) {
        classDomain.findById(cacheById.get(id).getAClass()).getStudents().remove(cacheById.get(id));
        cacheByName.remove(cacheById.get(id).getName());
        cacheById.remove(id);
    }

    public void update(Integer id, Integer idClass, String name) {
        Student newStudent = new Student();
        newStudent.setId(id);
        newStudent.setName(name);
        newStudent.setAClass(idClass);
        cacheByName.replace(cacheById.get(id).getName(), newStudent);
        cacheById.replace(id, newStudent);
    }
}
