package com.example.projetfacture.servlet;

import com.example.projetfacture.dao.ProductDao;
import com.example.projetfacture.models.InvoiceEntity;
import com.example.projetfacture.models.InvoiceProductEntity;
import com.example.projetfacture.models.ProductEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = AddFactureServlet.URL)
public class AddFactureServlet extends HttpServlet {
    public static final String URL = "/facture/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao product = new ProductDao();
        List<ProductEntity> productList = product.getAll();


        req.setAttribute("products", productList);

        req.getRequestDispatcher("/WEB-INF/form-facture.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateInvoice = req.getParameter("date");
        String serviceInvoice = req.getParameter("service");
        String serviceQuantityInvoice = req.getParameter("serviceQuantity");
        String priceHTInvoice = req.getParameter("priceHT");
        String priceTTCInvoice = req.getParameter("priceTTC");



        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setDateInvoice(Date.valueOf(dateInvoice));
        invoice.setMontantHtInvoice(Integer.valueOf(priceHTInvoice));
        invoice.setMontantTtcInvoice(Integer.valueOf(priceTTCInvoice));
        invoice.setInvoiceProductsByIdInvoice();

        InvoiceProductEntity invoiceProduct = new InvoiceProductEntity();
      /*  invoiceProduct.setIdInvoice();
        invoiceProduct.setIdProduct();*/

    }
}
