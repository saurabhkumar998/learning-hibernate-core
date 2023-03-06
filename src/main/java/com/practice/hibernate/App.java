package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started!!!" );

//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // creating configuration object using the configuration file
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        // creating a session factory
        SessionFactory factory = config.buildSessionFactory();

        System.out.println(factory);
        System.out.println(factory.isClosed());

        // creating student
        Student student = new Student();
        student.setId(102);
        student.setName("Saumya Kumar");
        student.setCity("New Delhi");

        System.out.println(student);

        // getting the current session from the session factory
//        Session session = factory.getCurrentSession();
        Session session = factory.openSession();

        // starting the transaction to save the student's data
        Transaction transaction = session.beginTransaction();

        // inserting the student details in the db using hibernate's save method
        session.save(student);

        // commiting the above changes (i.e. inserted student row)
        transaction.commit();

        // closing the current session
        session.close();








    }
}
