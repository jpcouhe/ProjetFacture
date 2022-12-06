package com.example.projetfacture.servlet;

import com.example.projetfacture.dao.ClientDao;
import com.example.projetfacture.models.ClientEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = AddFacture.URL)
public class AddFacture extends HttpServlet {
    public static final String URL = "/facture/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/WEB-INF/form-facture.jsp").forward(req, resp);
    }
}
