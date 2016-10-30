package com.courses.spalah;

import com.mysql.jdbc.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

/**
 * Created by Roman on 29.10.2016.
 */
public class AdressBook {
    public static void main (String [] args) {

        FormCreator createForm = new FormCreator();
        createForm.init();
        DataBaseManager dbManager = new DataBaseManager((Connection) new ConnectionManager().getConnection());
        createForm.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person person = new Person(0, createForm.getFirstRow().textField1.getText(), createForm.getFirstRow().textField2.getText(), new Adress(0,createForm.getFirstRow().textField3.getText()));
                if(dbManager.savePerson(person))
                    JOptionPane.showMessageDialog(new JFrame(), "Saved", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(new JFrame(), "Error!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        createForm.getReadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                try {
                    id = Integer.parseInt(createForm.getIdField().getText());
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(new JFrame(), "Введите правильный идентификатор личности в поле ID!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                Person person = dbManager.readPerson(id);
                createForm.getSecondRow().textField1.setText(person.getFirst_name());
                createForm.getSecondRow().textField2.setText(person.getLast_name());
                createForm.getSecondRow().textField3.setText(person.getAdress().getAdress());

            }
        });

    }
}
