package com.practice.hibernate.caching.levelOneCaching;

import com.practice.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class LevelOneCachingDemo {

    public static void main(String[] args) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();

        // calling the get method for the first time (it will cache the student obj in the session cache)
        System.out.println("Calling the get method for the first time :");
        System.out.println("The db query will be fired for the first time : ");
        System.out.println("-".repeat(50));
        Student student1 = session.get(Student.class, 1987);

        System.out.println(student1);

        System.out.println("-".repeat(50));

        System.out.println("Calling the get method for the second time :");
        System.out.println("The db script will not be fired when called for the second time :");

        Student student2 = session.get(Student.class, 1987);

        System.out.println(student2);

        System.out.println();



        session.close();
    }
}
