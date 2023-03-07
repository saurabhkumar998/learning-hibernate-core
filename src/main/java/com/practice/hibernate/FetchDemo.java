package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();

        // -> Both get and load methods are used to fetch data from  the  table. only diff is that load throws exception if the
        // value is not present in the table but get will return null if the value is not present.

        // get()  -> when we use the get method, it checks if the  object is present in the  session cache, if  it  is  present
        // in the session cache then it will return the object.
        // If the object is not present in the cache then only it will make a call to the database.

        // load()  ->  when we  used  the  load method, it returns a proxy of that object instead of the actual object iteself
        // it doesn't make any call to the database until we call any methods of that object(other than getId()).
        // this is lazy initialization, it increases performance

        //Student student = session.get(Student.class, 102);
        //Student student = session.load(Student.class, 102);

        //Address address = session.get(Address.class, 1);
        //  Address address = session.load(Address.class, 1);

        // here we are calling the get and load method to fetch the data of the student with id 1111 which is not present in
        // the database, which means the get method will return null value and the load method will throw an exception

        //Student student1 = session.get(Student.class, 1111);
        //System.out.println(student1);
        //Student student2 = session.load(Student.class, 1111);
        //System.out.println(student2);

        // here we are calling the get method for the same id hence when the get method is called for the first time, it will
        // cache the object for that id. when the get method is being called for the second time then it fetches the object
        // from  the cache instead of making call to the database again

        // Student student1 = session.get(Student.class, 101);
        // Student student2 = session.get(Student.class, 101);

        //System.out.println(student1);
        //System.out.println(student2);

        // here we are calling

        System.out.println("calling load method ....");
        Student student1 = session.load(Student.class, 101);
        System.out.println("DB call is not yet made because we have not used any method of the student1 object");

        System.out.println(student1.getName());
        System.out.println("DB call was made now because we have used the getName method of the object above");


        session.close();
        factory.close();


    }
}
