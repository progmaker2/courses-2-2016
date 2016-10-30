package com.courses.spalah;

/**
 * Created by Roman on 30.10.2016.
 */
public class Adress {
    private int id;
    private String adress;

    public Adress() {
    }

    public Adress(int id, String adress) {
        this.id = id;
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
