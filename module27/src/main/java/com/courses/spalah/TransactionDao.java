package com.courses.spalah;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Roman on 14.11.2016.
 */
public class TransactionDao {
    private SessionFactory factory;

    public TransactionDao(SessionFactory factory) {
        this.factory = factory;
    }

    public List<BankTransaction> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<BankTransaction> transactions = Collections.emptyList();
        try {
            tx = session.beginTransaction();
            transactions = session.createQuery("FROM transaction").list();
            for (Iterator iterator =
                 transactions.iterator(); iterator.hasNext(); ) {
                BankTransaction transaction = (BankTransaction) iterator.next();
                System.out.print("Get all transactions: " + transaction.toString());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return transactions;
    }

    public BankTransaction get(Long id) {

        return null;
    }

    public void save(BankTransaction employee) {
    }

    public void update(BankTransaction employee) {
    }

    public void delete(BankTransaction employee) {
    }

    public List<BankTransaction> findByName(String name) {
        return null;
    }

    public List<BankTransaction> findByNameWithCriteria(String name) {
        return null;
    }
}
