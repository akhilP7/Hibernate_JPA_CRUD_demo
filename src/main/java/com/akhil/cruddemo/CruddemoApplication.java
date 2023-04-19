package com.akhil.cruddemo;

import com.akhil.cruddemo.dao.StudentDAO;
import com.akhil.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner ->{
			System.out.println("Hello World");
	};}
	*/

	/*
	inject StudentDAO
	*/
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Akhil","Padala","akhil.reddy@gmail.com");

		//save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Kumar","Padala","kumar.reddy@gmail.com");
		Student tempStudent2 = new Student("Satya","Padala","satya.reddy@gmail.com");
		Student tempStudent3 = new Student("Pavan","Padala","pavan.reddy@gmail.com");

		System.out.println("Saving the students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating student object...");
		Student tempStudent = new Student("Ram","Reddy","Ram.reddy@gmail.com");

		System.out.println("Saving the students....");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: "+ myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByLastName("Padala");

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student

		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println(myStudent);

		//change first name
		System.out.println("Updating student....");
		myStudent.setFirstName("Akhil");

		//update the student
		studentDAO.update(myStudent);

		//display the updated
		System.out.println("Updated student: "+myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 5;
		System.out.println("Deleting student with id: "+studentId);
		studentDAO.delete(studentId);
	}


	private void deleteAllStudents(StudentDAO studentDAO) {

		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("No of rows deleted from Student: "+numRowsDeleted);
	}
}
