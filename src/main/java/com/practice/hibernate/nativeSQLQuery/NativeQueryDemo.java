package com.practice.hibernate.nativeSQLQuery;

import com.practice.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class NativeQueryDemo {
    public static void main(String[] args) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();

        String query = "select * from student";

        NativeQuery nativeQuery = session.createNativeQuery(query);

        List<Object[]> studentList = nativeQuery.list();

        for(Object[] s : studentList) {
            System.out.println(s[4] + " : " + s[3]);
        }


        session.close();


    }
}
