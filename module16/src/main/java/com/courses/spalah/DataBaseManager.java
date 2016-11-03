package com.courses.spalah;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Roman on 29.10.2016.
 */
public class DataBaseManager {
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

    public DataBaseManager() {
        Connection connection = (Connection) new ConnectionManager().getConnection();
        try {
            Statement statement = (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT count(*) FROM People.person");
            int columnCount = rs.getMetaData().getColumnCount();
        }
        catch (SQLException e) {
            if(e.getMessage().contains("Table 'People.person' doesn't exist"))
                init ();
            else
                System.err.println(e.getMessage());
            try {
                connection.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void init () {
        Connection connection = (Connection) new ConnectionManager().getConnection();
        try {
            Statement statement = (Statement) connection.createStatement();
            int rs = statement.executeUpdate(CREATE_PERSON_STRING);
            int rs2 = statement.executeUpdate(CREATE_ADRESS_STRING);
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            try {
                connection.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int saveAdress (Adress adress) {
        Connection connection = (Connection) new ConnectionManager().getConnection();
        int result = 0;
        try {
            PreparedStatement psSelectPerson = connection.prepareStatement(INSERT_ADRESS_STRING, Statement.RETURN_GENERATED_KEYS);
            psSelectPerson.setString(1, adress.getAdress());
            result = psSelectPerson.executeUpdate();
            ResultSet rs = psSelectPerson.getGeneratedKeys();

            if (rs.next()) {
                result = rs.getInt(1);
            }
            psSelectPerson.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            try {
                connection.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int savePerson (Person person) {
        int idAdress = saveAdress(person.getAdress());
        if(idAdress == 0)
            return 0;
        Connection connection = (Connection) new ConnectionManager().getConnection();
        person.setAdress(new Adress(idAdress,person.getAdress().getAdress()));
        int result = 0;
        try {
            PreparedStatement psSelectPerson = connection.prepareStatement(INSERT_PERSON_STRING, Statement.RETURN_GENERATED_KEYS);
            psSelectPerson.setString(1, person.getFirst_name());
            psSelectPerson.setString(2, person.getLast_name());
            psSelectPerson.setInt(3, person.getAdress().getId());
            result = psSelectPerson.executeUpdate();
            ResultSet rs = psSelectPerson.getGeneratedKeys();

            if (rs.next()) {
                result = rs.getInt(1);
            }
            psSelectPerson.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            try {
                connection.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Person readPerson (int id) {
        if(id == 0)
            return null;
        Connection connection = (Connection) new ConnectionManager().getConnection();
        String first_name = "";
        String last_name = "";
        Adress adress = new Adress();
        try {
            System.out.println(READ_PERSON+id+" AND 1=1;");
            Statement statement = (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(READ_PERSON+id+" AND 1=1;");
            rs.next();
            id = rs.getInt("id");
            first_name = rs.getString("first_name");
            last_name = rs.getString("last_name");
            adress = new Adress(rs.getInt("adress_id"), rs.getString("adress"));
        }
        catch (SQLException e) {
                System.err.println(e.getMessage());
            try {
                connection.close();
            } catch (SQLException e3) {
                e.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Person(id, first_name, last_name, adress);
    }
    public ArrayList<Person> getAllPersons () {
        Connection connection = (Connection) new ConnectionManager().getConnection();
        ArrayList<Person> result = new ArrayList<Person>();
        Adress adress = new Adress();
        try {
            System.out.println(READ_ALL_PERSONS);

            Statement statement = (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(READ_ALL_PERSONS);
            while (rs.next()) {
                Person onePerson = new Person();
                onePerson.setId(rs.getInt("id"));
                onePerson.setFirst_name(rs.getString("first_name"));
                onePerson.setLast_name(rs.getString("last_name"));
                onePerson.setAdress(new Adress(rs.getInt("adress_id"),rs.getString("adress")));
                result.add(onePerson);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            try {
                connection.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
