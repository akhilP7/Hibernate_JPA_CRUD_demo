package com.akhil.cruddemo.dao;

import com.akhil.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    /*
    for creating a new student
    */
    void save(Student theStudent);

    /*
    for read operation
    */
    Student findById(Integer id);

    /*
    for querying all objects (read operation)
    */
    List<Student> findAll();

    /*
    for querying all objects (read operation)
    */
    List<Student> findByLastName(String theLastName);

    /*
    for updating a student
    */
    void update(Student theStudent);

    /*
    for deleting a student
    */
    void delete(Integer id);

    /*
    for deleting a student
    */
    int deleteAll();
}
