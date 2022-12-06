package com.example.projetfacture.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = LoginServlet.URL)
public class LoginServlet extends HttpServlet {

    public static final String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("pseudo") != null) {
            resp.sendRedirect(ClientServlet.URL);
        } else{
            req.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pseudo = req.getParameter("pseudo");
        String password = req.getParameter("password");

        if (pseudo.equals("admin") && password.equals("qwerty")) {
            // Get existing session or create one if not exist
            HttpSession session = req.getSession(true);

            session.setAttribute("pseudo", pseudo);
            // Expiration after 30 minutes
            session.setMaxInactiveInterval(30 * 60);

            resp.sendRedirect(ClientServlet.URL);
        } else {
            req.setAttribute("loginFail", true);
            doGet(req, resp);
        }

    }



}
