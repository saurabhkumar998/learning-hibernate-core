package com.practice.hibernate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable                 // it tells hibernate that this class is embeddable to other classes(if used in them)
public class Certificate {

    private String course;
    private String duration;

    public Certificate() {
    }

    public Certificate(String course, String duration) {
        this.course = course;
        this.duration = duration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "course='" + course + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
