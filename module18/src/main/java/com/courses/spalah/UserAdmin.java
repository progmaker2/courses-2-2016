package com.courses.spalah;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Roman on 31.10.2016.
 */
public class UserAdmin extends HttpServlet {
    private AdminPage page;
    @Override
    public void init() throws ServletException {
        super.init();
        this.page = new AdminPage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null) {
            try {
                response.getWriter().write(page.getContentByOnePerson(Integer.parseInt(request.getParameter("id"))));
            }
            catch (NumberFormatException e) {
                response.getWriter().write(page.getContent(page.ERROR_READ_PERSON_MESSAGE));
            }
        }
        response.getWriter().write(page.getContent(""));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        response.getWriter().write(page.getContent(""));
    }
}
