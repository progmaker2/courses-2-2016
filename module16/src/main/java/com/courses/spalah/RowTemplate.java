package com.courses.spalah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roman on 29.10.2016.
 */
public class RowTemplate {
    private JFrame frame;
    protected JTextField textField1;
    protected JTextField textField2;
    protected JTextField textField3;
    public RowTemplate (JFrame frame) {
        this.frame = frame;
        this.textField1 = new JTextField(10);
        textField1.setText("Имя");
        this.textField2 = new JTextField(10);
        textField2.setText("Фамилия");
        this.textField3 = new JTextField(10);
        textField3.setText("Адрес");
    }
}

