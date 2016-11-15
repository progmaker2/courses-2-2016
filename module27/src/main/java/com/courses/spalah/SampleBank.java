package com.courses.spalah;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Roman on 14.11.2016.
 */
public class SampleBank {
    public static void main(String[] args) {
        // создаем конфигурацию
        Configuration cfg=new Configuration();
        // конфигурим с помощью XML-файла
        cfg.configure("hibernate.cfg.xml");

        // создаем фабрику сессий
        SessionFactory factory=cfg.buildSessionFactory();
        // создаем сессию
        Session session=factory.openSession();

        BankTransaction transaction = (BankTransaction) session.load(BankTransaction.class,1l);
        Hibernate.initialize(transaction.toString());
        //session.getTransaction().commit();
        System.out.println(transaction.getId());
    }
}
