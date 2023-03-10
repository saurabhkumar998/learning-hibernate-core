package com.practice.hibernate.hql;

import com.practice.hibernate.Certificate;
import com.practice.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InputDataToDB {

    public static void insertDummyData() {

        Student student1 =
                new Student(1111, "Virat Kohli",
                        "New Delhi",
                        new Certificate("Batting MasterClass", "5 Years"));

        Student student2 =
                new Student(1987, "Jasprit Bumrah",
                        "Punjab",
                        new Certificate("Bowling MasterClass", "3 Years"));



        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        transaction.commit();
        session.close();


    }
}
