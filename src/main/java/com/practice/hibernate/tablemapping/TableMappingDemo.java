package com.practice.hibernate.tablemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TableMappingDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        // creating question

        Answer answer = new Answer(201, "Java is a programming language");
        Question question = new Question(101, "What is Java?", answer);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(question);
        session.save(answer);

        transaction.commit();
        session.close();
        factory.close();
    }
}
