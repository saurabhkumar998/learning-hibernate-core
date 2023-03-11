package com.practice.hibernate.cascade;

import com.practice.hibernate.onetomanymapping.Answer;
import com.practice.hibernate.onetomanymapping.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CascadeDemo {
    public static void main(String[] args) {

        Question question = new Question();
        question.setQuestionId(4333);
        question.setQuestion("What is Python?");

        Answer answer1 = new Answer();
        answer1.setAnswerId(908);
        answer1.setAnswer("Python is a scripting language");
        answer1.setQuestion(question);

        Answer answer2 = new Answer();
        answer2.setAnswerId(561);
        answer2.setAnswer("Python is a very simple language.");
        answer2.setQuestion(question);

        question.setAnswers(List.of(answer1, answer2));


        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // here we are only saving the question, the associated answers will be automatically saved because we have used cascade in the Question Entity(refer the Question class for reference)
        session.save(question);

        transaction.commit();
        session.close();
    }
}
