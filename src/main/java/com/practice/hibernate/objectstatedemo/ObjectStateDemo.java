package com.practice.hibernate.objectstatedemo;

import com.practice.hibernate.Certificate;
import com.practice.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ObjectStateDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // Transient State : here the below student object is in transient state because it is not yet associated with the session
        Student student =
                new Student(109, "Virat Kohli",
                        "Mumbai",
                        new Certificate("Batting MasterClass", "1 Years"));


        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // Persistent State : here the student object is in persistent state because it is associated with the session(when we called session.save() method)
        session.save(student);

        // the below update will be visible in the database because the object is still in persistent state(i.e. the session is not closed/cleared yet)
        student.setName("Sachin Ramesh Tendulkar");

        transaction.commit();
        session.close();

        // Detached State : here the object is in detached state because we have closed the session(i.e. the object is not associated with the session anymore)
        // the below update will not reflect in the database
        student.setName("M.S Dhoni");

        System.out.println(student);

        factory.close();
    }
}
