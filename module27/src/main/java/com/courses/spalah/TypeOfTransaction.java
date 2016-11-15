package com.courses.spalah;

import javax.persistence.*;

/**
 * Created by Roman on 14.11.2016.
 */
@Entity
@Table(name="transaction_types")
public class TypeOfTransaction {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="name_of_transaction")
    private String nameOfTransaction;

    public TypeOfTransaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTransaction() {
        return nameOfTransaction;
    }

    public void setNameOfTransaction(String nameOfTransaction) {
        this.nameOfTransaction = nameOfTransaction;
    }
}
