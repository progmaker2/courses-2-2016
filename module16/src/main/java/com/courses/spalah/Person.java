package com.courses.spalah;

/**
 * Created by Roman on 29.10.2016.
 */
public class Person implements PersonBehavior {
    private int id;
    private String first_name;
    private String last_name;
    private Adress adress;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(int id, String first_name, String last_name, Adress adress) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.adress = adress;
    }
    public Person(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Person b) {
        int temp = b.getId();
        if (temp == this.getId()) return true;
        else return false;
    }
}
