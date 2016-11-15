package com.courses.spalah;

import javax.persistence.*;

/**
 * Created by Roman on 14.11.2016.
 */
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "payer_account", orphanRemoval = true)
    @JoinColumn(name="payer_account", nullable = true)*/
    @Column(name="account")
    private String account;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "payer_id", orphanRemoval = true)
    @JoinColumn(name="payer_id", nullable = true)*/
    @Transient
    private Person client;
    @Transient
    private double balance;

    public Account() {
    }

    public Account(String account, Person client, double balance) {
        this.account = account;
        this.client = client;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", balance=" + balance +
                '}';
    }
}
