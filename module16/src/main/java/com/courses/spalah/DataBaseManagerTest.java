package com.courses.spalah;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Roman on 29.10.2016.
 */
public class DataBaseManagerTest {
    private static final String CREATE_PERSON_STRING;
    private static final String CREATE_ADRESS_STRING;
    private static final String READ_PERSON;
    private static final String INSERT_PERSON_STRING;
    private static final String INSERT_ADRESS_STRING;
    private static final String READ_ALL_PERSONS;
    static {
        CREATE_PERSON_STRING = "Create Table  IF NOT EXISTS People.person\n" +
                "(\n" +
                "id int NOT NULL AUTO_INCREMENT,\n" +
                "first_name varchar(255),\n" +
                "last_name varchar(255),\n" +
                "adress_id int,\n" +
                "primary key(id)\n" +
                ");";
        CREATE_ADRESS_STRING = "CREATE TABLE if not exists People.adress (\n" +
                "  id      INT NOT NULL AUTO_INCREMENT,\n" +
                "  adress VARCHAR(255),\n" +
                "  primary key(id)" +
                ");";
        READ_PERSON = "SELECT t1.id," +
                "t1.first_name," +
                "t1.last_name," +
                "t1.adress_id," +
                "t2.adress " +
                "FROM people.person t1 " +
                "LEFT JOIN people.adress t2 on t1.adress_id = t2.id " +
                "WHERE t1.id =";
        READ_ALL_PERSONS = "SELECT t1.id," +
                "t1.first_name," +
                "t1.last_name," +
                "t1.adress_id," +
                "t2.adress " +
                "FROM people.person t1 " +
                "LEFT JOIN people.adress t2 on t1.adress_id = t2.id ";
        INSERT_PERSON_STRING = "insert into People.person (first_name, last_name, adress_id) values (?,?,?);\n";
        INSERT_ADRESS_STRING = "insert into People.adress (adress) values (?);\n";
    }

    public DataBaseManagerTest() {
    }
    public void init () {
    }
    public int saveAdress (Adress adress) {
        return 1;
    }
    public int savePerson (Person person) {
        return 1;
    }
    public Person readPerson (int id) {
        return new Person(1, "ivan", "ivanov", new Adress(1,"Dnepr"));
    }
    public ArrayList<Person> getAllPersons () {
        ArrayList<Person> result = new ArrayList<Person>();

        return result;
    }
}
