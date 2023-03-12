package com.practice.hibernate.onetomanymapping;

import javax.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;
//    @OneToMany
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)    // if we use the mappedBy property then it will not create a mapping table in turn  it will rely on the mapped column
    private List<Answer> answers;

    public Question() {
    }

    public Question(int questionId, String question, List<Answer> answer) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answer=" + answers +
                '}';
    }
}
