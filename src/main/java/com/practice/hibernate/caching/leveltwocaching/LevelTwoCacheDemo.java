package com.practice.hibernate.caching.leveltwocaching;

import com.practice.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LevelTwoCacheDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // first session
        Session session1 = factory.openSession();

        Student student1 = session1.get(Student.class, 1987);
        System.out.println(student1);

        session1.close();

        // second session
        Session session2 = factory.openSession();
        // we are calling the get method outside the previous session but it is still accessing the data from the cache because we have used level two cache
        Student student2 = session2.get(Student.class, 1987);
        System.out.println(student2);

        session2.close();
    }
}
