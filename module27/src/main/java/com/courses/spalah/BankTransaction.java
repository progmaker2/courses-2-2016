package com.courses.spalah;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Roman on 14.11.2016.
 */
@Entity
@Table(name="transactions")
public class BankTransaction {
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="payer_account")
    private Account payerAccount;
    @ManyToOne
    @JoinColumn(name="receiver_account")
    private Account receiverAccount;
    @Column(name="sum_of_money")
    private double sum;
    @Column(name="date_of_transaction")
    private Date dateOfTransaction;
    @ManyToOne
    @JoinColumn(name="type_of_transaction")
    private TypeOfTransaction typeOfTransaction;

    public BankTransaction() {
    }

    /*public BankTransaction(String payerAccount, String receiverAccount, double sum, TypeOfTransaction typeOfTransaction) {
        this.payerAccount = payerAccount;
        this.receiverAccount = receiverAccount;
        this.sum = sum;
        this.typeOfTransaction = typeOfTransaction;
        this.dateOfTransaction = new Date();
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public TypeOfTransaction getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(TypeOfTransaction typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

}
