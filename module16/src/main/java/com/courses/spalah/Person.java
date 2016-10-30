package com.courses.spalah;

/**
 * Created by Roman on 29.10.2016.
 */
public class Person {
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
}
