package com.amit.spring.model;

import java.util.Set;

import lombok.Data;

@Data
public class Class {
    private int id;
    private String name;
    private Set<Student> students;

    // @Override
    // public boolean equals(Object o) {
    // if (this == o)
    // return true;
    // if (o == null || getClass() != o.getClass())
    // return false;
    // Class aClass = (Class) o;
    // return id == aClass.id;
    // }

    // @Override
    // public int hashCode() {
    // return id;
    // }
}
