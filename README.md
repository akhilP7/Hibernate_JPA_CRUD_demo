# Hibernate_JPA_CRUD_demo
Spring boot demo - Database access with Hibernate/JPA CRUD operations

1. Created a Student.class with all the fields(id,firstName,lastName,email) along with the automatic datasource configuration(mapping the entity class with the annotations to map between the entity fields and database columns).

2. Created a StudentDAO(student data access object) interface having all the methods.

3. Implemented StudentDAO with @Repository as a subsidary of @Component to do CRUD operations on objects.

#Configure JPA/Hibernate for auto creation of tables
1. spring.jpa.hibernate.ddl-auto = update 

#Configure mysql database connection
1. spring.datasource.url=jdbc:mysql://localhost:portnumber/databaseName
2. spring.datasource.username = ****
3. spring.datasource.password = ****