package com.amit.spring.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.amit.spring.model.Class;
import com.amit.spring.model.Student;

import org.springframework.stereotype.Component;

@Component
public class ClassDomain {
    private Map<String, Class> cacheByName = new HashMap<>();
    private Map<Integer, Class> cacheById = new HashMap<>();
    private static int IDD = 0;

    private synchronized int getIDD() {
        IDD++;
        return IDD;
    }

    public Class findByName(String name) {
        return cacheByName.get(name);
    }

    public Class findById(Integer id) {
        return cacheById.get(id);
    }

    public List<Class> getAllClass() {
        return new ArrayList<>(cacheById.values());
    }

    public void createdClass(String name) {
        Class newClass = new Class();
        newClass.setId(this.getIDD());
        newClass.setName(name);
        newClass.setStudents(new HashSet<Student>());
        cacheById.put(newClass.getId(), newClass);
        cacheByName.put(name, newClass);
    }

    public void delete(Integer id) {
        cacheByName.remove(cacheById.get(id).getName());
        cacheById.remove(id);
    }

    public void update(Integer id, String name) {
        Class newClass = new Class();
        newClass.setId(id);
        newClass.setName(name);
        newClass.setStudents(cacheByName.get(name).getStudents());
        cacheByName.remove(cacheById.get(id).getName());
        cacheById.replace(id, newClass);
        cacheByName.put(name, newClass);

    }

    public List<Student> getListStudent(Integer id) {
        return new ArrayList<>(cacheById.get(id).getStudents());
    }

    // public void addStudent(Integer id, Student student) {
    // cacheById.get(id).getStudents().add(student);
    // }
}
