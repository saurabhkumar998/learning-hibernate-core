package com.practice.hibernate.manytomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.ObjectInputFilter;
import java.util.List;

public class ManyToManyMappingDemo {

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setEmployeeId(34);
        employee1.setEmployeeName("Saurabh Kumar");

        employee2.setEmployeeId(35);
        employee2.setEmployeeName("Saumya Kumar");

        Project project1 = new Project();
        Project project2 = new Project();

        project1.setProjectId(111);
        project1.setProjectName("LMS");

        project2.setProjectId(222);
        project2.setProjectName("UMS");

        List<Employee> employeeList = List.of(employee1, employee2);
        List<Project> projectList = List.of(project1, project2);

        employee1.setProjects(projectList);
        employee2.setProjects(projectList);

        project1.setEmployees(employeeList);
        project2.setEmployees(employeeList);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);


        transaction.commit();
        session.close();
        factory.close();




    }
}
