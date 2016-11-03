package com.courses.spalah;

import com.mysql.jdbc.Connection;

import java.util.ArrayList;

/**
 * Created by Roman on 31.10.2016.
 */
public class AdminPage {
    private static final String PAGE_HEAD;
    private static final String PAGE_BODY_START;
    private static final String PAGE_BODY_END;
    protected static final String SAVED_PERSON_MESSAGE;
    protected static final String ERROR_READ_PERSON_MESSAGE;
    private static final String CONTROLL_FORMS;
    private ArrayList<Person> Content;

    static {
        PAGE_HEAD = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n<title>Administrator page</title></head>";
        PAGE_BODY_START = "<body>";
        PAGE_BODY_END = "</body></html>";
        SAVED_PERSON_MESSAGE = "<p style=\"font-color: green;\">Новый пользователь добавлен!</p>";
        ERROR_READ_PERSON_MESSAGE = "<p style=\"font-color: green;\">Новый пользователь добавлен!</p>";
        CONTROLL_FORMS = "<h2>Получение пользователя по ID. Введите ID:</h2>\n" +
                "<form name=\"readPerson\" method=\"get\">\n" +
                "ID: <input name=\"id\" type=\"text\" />\n" +
                "<input name=\"submit\" type=\"submit\" value=\"Получить!\" />\n" +
                "</form>\n" +
                "<br />\n" +
                "<h2>Добавление пользователя:</h2>\n" +
                "<form name=\"savePerson\" method=\"post\">\n" +
                "<input name=\"doSave\" type=\"hidden\" />\n" +
                "<table border =\"0\"><tr><td>ID: </td><td><input name=\"id\" type=\"text\" /></td></tr>\n" +
                "<tr><td>Имя: </td><td><input name=\"first_name\" type=\"text\" /></td></tr>\n" +
                "<tr><td>Фамилия: </td><td><input name=\"last_name\" type=\"text\" /></td></tr>\n" +
                "<tr><td>ID Адреса: </td><td><input name=\"id\" type=\"text\" /></td></tr>\n" +
                "<tr><td>Адрес: </td><td><input name=\"adress\" type=\"text\" /></td></tr></table>\n" +
                "<input name=\"submit\" type=\"submit\" value=\"Добавить!\" />\n" +
                "</form>";
    }
    public AdminPage () {
        DataBaseManager dbManager = new DataBaseManager();
        this.Content = dbManager.getAllPersons();
    }
    public String getContent(String beforeContent) {
        String finalContent = PAGE_HEAD+PAGE_BODY_START+beforeContent+CONTROLL_FORMS;
        for(Person element:Content) {
            finalContent += getHTMLPerson(element);
        }
        return finalContent+PAGE_BODY_END;
    }
    public void addElement(Person element) {
        Content.add(element);
        DataBaseManager dbManager = new DataBaseManager();
        dbManager.savePerson(element);
    }
    public void removeElement(int id) {
        Content.remove(this.findDefiniteElement(id));
    }

    public String getContentByOnePerson(int id) {
        String finalContent = PAGE_HEAD+PAGE_BODY_START;
        finalContent += getHTMLPerson(Content.get(this.findDefiniteElement(id)));
        return finalContent+PAGE_BODY_END;
    }
    public String getHTMLPerson(Person person) {
        return "<p><table border=0><tr><td>"+person.getId()+"</td>"+
                "<td>"+person.getFirst_name()+"</td>"+
                "<td>"+person.getLast_name()+"</td>"+
                "<td>"+person.getAdress().getId()+"</td>"+
                "<td>"+person.getAdress().getAdress()+"</td>"+
                "</tr></table>";
    }

    public int findDefiniteElement (int id) {
        for(Person element:Content) {
            if(element.equals(new Person(id)))
                return Content.indexOf(element);
        }
        return -1;
    }
}
