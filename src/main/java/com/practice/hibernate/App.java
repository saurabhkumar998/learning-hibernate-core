package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Project Started!!!" );

//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // creating configuration object using the configuration file
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        // creating a session factory
        SessionFactory factory = config.buildSessionFactory();

        System.out.println(factory);
        System.out.println(factory.isClosed());

        // creating object of Student class
        Student student1 = new Student(101, "Saurabh Kumar", "Bangalore");
        Student student2 = new Student(103, "Gaurav Kumar", "Laxmi Nagar");
        Student student3 = new Student(104, "Santu Kumar", "Gopalganj");



        // creating object of Address class
        Address address = new Address();
        address.setStreet("Street2");
        address.setCity("Pune");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(43334.6);


        // Reading image
        FileInputStream fs = new FileInputStream("src/main/java/1kb.png");
        byte[] imageInByte = new byte[fs.available()];
        fs.read(imageInByte);
        address.setImage(imageInByte);



        // getting the current session from the session factory
//        Session session = factory.getCurrentSession();
        Session session = factory.openSession();

        // starting the transaction to save the student's data
        Transaction transaction = session.beginTransaction();

        // inserting the student details in the db using hibernate's save method
        session.save(student1);
        session.save(student2);
        session.save(student3);


        // inserting the address object in the db
        session.save(address);

        // committing the above changes (i.e. inserted student row)
        transaction.commit();

        // closing the current session
        session.close();
        factory.close();

        System.out.println("Done!!");








    }
}
