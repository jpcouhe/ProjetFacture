package com.example.projetfacture.servlet;

import com.example.projetfacture.dao.ClientDao;
import com.example.projetfacture.dao.DaoInvoice;
import com.example.projetfacture.models.ClientEntity;
import com.example.projetfacture.models.InvoiceEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "DeleteFacture", value = "/facture/delete")
public class DeleteFacture extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            int id = Integer.parseInt(idStr);
            DaoInvoice invoiceDao = new DaoInvoice();

            Optional<InvoiceEntity> invoice = invoiceDao.get(id);

            if (invoice.isPresent()) {
                invoiceDao.delete(invoice.get());
                resp.sendRedirect(req.getContextPath() + "/client");
            } else {
                System.out.println("Aucun client");
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

    }
}
