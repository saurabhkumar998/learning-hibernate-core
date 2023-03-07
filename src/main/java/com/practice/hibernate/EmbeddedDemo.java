package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        Student student1 =
                new Student(109, "Virat Kohli",
                        "Mumbai",
                        new Certificate("Batting MasterClass", "1 Years"));

        Student student2 =
                new Student(110, "M.S. Dhoni",
                        "Ranchi",
                        new Certificate("Captaining MasterClass", "2 Years"));


        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        transaction.commit();

        session.close();
        factory.close();
    }
}
