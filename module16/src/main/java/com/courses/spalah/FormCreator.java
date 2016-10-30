package com.courses.spalah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roman on 29.10.2016.
 */
public class FormCreator {
    protected RowTemplate firstRow;
    protected RowTemplate secondRow;
    protected JButton saveButton;
    protected JButton readButton;
    protected JFrame frame;
    protected JTextField idField;

    public void init() {
        frame = new JFrame();
        frame.setTitle("New Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.setLayout(new GridBagLayout());

        saveButton = new JButton("Сохранить");
        readButton = new JButton("Прочитать");
        saveButton.setBackground(Color.GREEN);
        readButton.setBackground(new Color(8,131,175) );
        readButton.setForeground(Color.WHITE );
        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        saveButton.setCursor(handCursor);
        readButton.setCursor(handCursor);

        firstRow = new RowTemplate(frame);
        frame.add(firstRow.textField1, new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));
        frame.add(firstRow.textField2, new GridBagConstraints(2,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));
        frame.add(firstRow.textField3, new GridBagConstraints(3,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));
        frame.add(saveButton, new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));
        frame.add(readButton, new GridBagConstraints(1,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));
        idField = new JTextField("ID");
        frame.add(idField, new GridBagConstraints(2,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));

        secondRow = new RowTemplate(frame);
        frame.add(secondRow.textField1, new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));
        frame.add(secondRow.textField2, new GridBagConstraints(2,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));
        frame.add(secondRow.textField3, new GridBagConstraints(3,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new java.awt.Insets(2,2,2,2),0,0));
        frame.setVisible(true);
        frame.pack();
    }

    public RowTemplate getFirstRow() {
        return firstRow;
    }

    public RowTemplate getSecondRow() {
        return secondRow;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getReadButton() {
        return readButton;
    }

    public JTextField getIdField() {
        return idField;
    }
}