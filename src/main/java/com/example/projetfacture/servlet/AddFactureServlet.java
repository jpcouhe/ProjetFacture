package com.example.projetfacture.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = AddFactureServlet.URL)
public class AddFactureServlet extends HttpServlet {
    public static final String URL = "/facture/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/WEB-INF/form-facture.jsp").forward(req, resp);
    }
}
