package com.practice.hibernate.hql;

import com.practice.hibernate.Certificate;
import com.practice.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlDemo {
    public static void main(String[] args) {

        // inserting dummy data to the db using the below method
/*
        System.out.println("Calling the insertDummyData method - start");
        InputDataToDB.insertDummyData();
        System.out.println("Calling the insertDummyData method - end");
*/
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();

        // query 1
        String query1 = "from Student";

        Query builtQuery1 = session.createQuery(query1);

        List<Student> students = builtQuery1.list();

        System.out.println("Printing results from query1 : ");
        for(Student s : students) {
            System.out.println(s);
        }
        // query2
        String query2 = "from Student where city='New Delhi'";

        Query builtQuery2 = session.createQuery(query2);
        List<Student> studentsFromNewDelhi = builtQuery2.list();

        System.out.println("Printing results from query2 : ");

        for(Student s : studentsFromNewDelhi) {
            System.out.println(s);
        }

        // using dynamic query
        String query3 = "from Student where city=:enteredCity";

        Query builtQuery3 = session.createQuery(query3);

        builtQuery3.setParameter("enteredCity", "Punjab");

        List<Student> studentsFromPunjab = builtQuery3.list();

        System.out.println("Printing results of the query3 : ");
        for(Student s : studentsFromPunjab) {
            System.out.println(s);
        }

        // using dynamic query with alias
        String query4 = "from Student as s where s.city=:enteredCity and s.name=:enteredName";

        Query builtQuery4 = session.createQuery(query4);
        builtQuery4.setParameter("enteredCity", "Mumbai");
        builtQuery4.setParameter("enteredName", "Cheteshwar Pujara");

        Student pujji = (Student) builtQuery4.getSingleResult();

        System.out.println("Printing results of query4 : ");
        System.out.println(pujji);

        session.close();
    }
}
