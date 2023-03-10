package com.practice.hibernate.onetomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TableMappingDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        // creating question


        Question question = new Question();
        question.setQuestionId(101);
        question.setQuestion("What is Java?");

        Answer answer1 = new Answer();
        answer1.setAnswerId(201);
        answer1.setAnswer("Java is a programming language");

        Answer answer2 = new Answer();
        answer2.setAnswerId(999);
        answer2.setAnswer("Java is commonly used for web application backend.");

        question.setAnswers(List.of(answer1, answer2));

        answer1.setQuestion(question);
        answer2.setQuestion(question);


        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

//        session.save(question);
//        session.save(answer1);
//        session.save(answer2);

        Question fetchedQuestion = session.get(Question.class, 101);
        System.out.println(fetchedQuestion.getQuestion());

//        for(Answer a : fetchedQuestion.getAnswers()) {
//            System.out.println(a.getAnswer());
//        }

        transaction.commit();
        session.close();
        factory.close();
    }
}
