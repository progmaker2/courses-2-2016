package com.courses.spalah;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Roman on 31.10.2016.
 */
public class UserAdmin extends HttpServlet {
    private AdminPage page;

    public UserAdmin() {
        init();
        this.page = new AdminPage();
    }

    @Override
    public void init() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /*if(request.getParameter("id") != null) {
            try {
                response.getWriter().write(page.getContentByOnePerson(Integer.parseInt(request.getParameter("id"))));
            }
            catch (NumberFormatException e) {
                response.getWriter().write(page.getContent(page.ERROR_READ_PERSON_MESSAGE));
            }
        }
        response.getWriter().write(page.getContent(""));*/
        response.getWriter().write("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "<title>Administrator page</title></head><body><h2>Получение пользователя по ID. Введите ID:</h2>\n" +
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
                "</form><p><table border=0><tr><td>1</td><td>Ivan</td><td>Ivanov</td><td>1</td><td>Dnipro</td></tr></table><p><table border=0><tr><td>2</td><td>Ivan1</td><td>Ivanov1</td><td>1</td><td>Dnipro</td></tr></table><p><table border=0><tr><td>3</td><td>Имя</td><td>Фамилия</td><td>1</td><td>Dnipro</td></tr></table><p><table border=0><tr><td>4</td><td>Имя2</td><td>Фамилия2</td><td>1</td><td>Dnipro</td></tr></table><p><table border=0><tr><td>5</td><td>Имя3</td><td>Фамилия3</td><td>1</td><td>Dnipro</td></tr></table><p><table border=0><tr><td>6</td><td>Имя4</td><td>Фамилия4</td><td>1</td><td>Dnipro</td></tr></table><p><table border=0><tr><td>7</td><td>Имя5</td><td>Фамилия5</td><td>1</td><td>Dnipro</td></tr></table><p><table border=0><tr><td>8</td><td>нормальное имя</td><td>нормальная Фамилия</td><td>6</td><td>Нормальный адресАдрес</td></tr></table><p><table border=0><tr><td>9</td><td>111111111</td><td>22222222222</td><td>7</td><td>33333333</td></tr></table><p><table border=0><tr><td>10</td><td>Имя</td><td>Фамилия</td><td>8</td><td>Адрес</td></tr></table><p><table border=0><tr><td>11</td><td>Имя8888888</td><td>Фамилия8888888</td><td>9</td><td>Адрес888888</td></tr></table><p><table border=0><tr><td>12</td><td>Имя88888889</td><td>Фамилия88888889</td><td>10</td><td>Адрес8888889</td></tr></table><p><table border=0><tr><td>13</td><td>Имя9999999</td><td>999Фамилия</td><td>11</td><td>Адрес999999</td></tr></table><p><table border=0><tr><td>14</td><td>Имя55</td><td>Фамилия55</td><td>12</td><td>Адрес55</td></tr></table><p><table border=0><tr><td>15</td><td>ww</td><td>ww</td><td>13</td><td>ww</td></tr></table></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=utf-8");
        if(request.getParameter("doSave") != null &&
                request.getParameter("id") != null &&
                request.getParameter("first_name") != null &&
                request.getParameter("last_name") != null &&
                request.getParameter("adress_id") != null &&
                request.getParameter("adress") != null) {
            try {
                Person personToSave = new Person();
                personToSave.setId(Integer.parseInt(request.getParameter("id")));
                personToSave.setFirst_name(request.getParameter("first_name"));
                personToSave.setFirst_name(request.getParameter("last_name"));
                personToSave.setAdress(new Adress(Integer.parseInt(request.getParameter("adress_id")), request.getParameter("adress")));
                page.addElement(personToSave);
                response.getWriter().write(page.getContent(page.SAVED_PERSON_MESSAGE));
            }
            catch (NumberFormatException e) {
                response.getWriter().write(page.getContent("<p style=\"font-color: red; font-weight: bold;\">Ошибка! Введен не правильный ID пользователя!</p>"));
            }
        }
        response.getWriter().write(page.getContent(""));*/
    }

    public AdminPage getPage() {
        return page;
    }
}
