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


        Question question = new Question();
        question.setQuestionId(101);
        question.setQuestion("What is Java?");

        Answer answer = new Answer();
        answer.setAnswerId(201);
        answer.setAnswer("Java is a programming language");
        question.setAnswer(answer);
        answer.setQuestion(question);


        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(question);
        session.save(answer);

        transaction.commit();
        session.close();
        factory.close();
    }
}
