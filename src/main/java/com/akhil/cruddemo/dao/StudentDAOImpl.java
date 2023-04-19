package com.akhil.cruddemo.dao;

import com.akhil.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    /*
    define field for entity manager
    */
    private EntityManager entityManager;

    /*
    inject entity manager using autowired constructor
    */
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
    implement save method
    */
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    /*
    implement findById
    */
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    /*
    implement findAll
    */
    @Override
    public List<Student> findAll() {

        //create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName",Student.class); // Name of JPA Entity... the class name

        return theQuery.getResultList();
    }

    /*
    implement findAll
    */
    @Override
    public List<Student> findByLastName(String theLastName) {

        //create a query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student where lastName=: theData",Student.class); // Name of JPA Entity... the class name

        theQuery.setParameter("theData",theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student theStudent = entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("Delete from Student").executeUpdate();
        return numRowsDeleted;
    }
}
