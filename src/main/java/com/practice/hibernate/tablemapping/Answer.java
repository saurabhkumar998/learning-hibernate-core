package com.practice.hibernate.tablemapping;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToOne
    private Question question;

    public Answer() {
    }

    public Answer(int answerId, String answer, Question question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    public Question getQuestion() {
        return this.question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                '}';
    }
}
