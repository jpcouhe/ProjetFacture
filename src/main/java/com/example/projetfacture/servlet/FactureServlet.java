package com.example.projetfacture.servlet;


import com.example.projetfacture.dao.DaoInvoice;
import com.example.projetfacture.models.InvoiceEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = FactureServlet.URL)
public class FactureServlet extends HttpServlet {

    public static final String URL = "/client/facture";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        DaoInvoice dao = new DaoInvoice();
        Optional<List<InvoiceEntity>> invoiceEntity = dao.getInvoiceByIdClient(Integer.parseInt(id));

        if(invoiceEntity.isPresent()){
            req.setAttribute("clientId", id);
            req.setAttribute("invoices", invoiceEntity.get());
        }
        else{
            System.out.println("Il n'existe pas de facture pour ce client");
        }

        req.getRequestDispatcher("/WEB-INF/facture-list.jsp").forward(req, resp);
    }

}
