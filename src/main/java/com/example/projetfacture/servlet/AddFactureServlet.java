package com.example.projetfacture.servlet;

import com.example.projetfacture.dao.ClientDao;
import com.example.projetfacture.dao.DaoInvoice;
import com.example.projetfacture.dao.ProductDao;
import com.example.projetfacture.models.ClientEntity;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = AddFactureServlet.URL)
public class AddFactureServlet extends HttpServlet {
    public static final String URL = "/facture/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idclient = req.getParameter("id");
        ProductDao product = new ProductDao();
        List<ProductEntity> productList = product.getAll();

try{

    ClientDao clientDao = new ClientDao();
    Optional<ClientEntity> client = clientDao.get(Integer.parseInt(idclient));


    if(client.isPresent()){

        req.setAttribute("products", productList);
        req.setAttribute("clientId", idclient);
        req.setAttribute("client", client.get());
        req.getRequestDispatcher("/WEB-INF/form-facture.jsp").forward(req, resp);
    }else{
        req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
    }
}catch (NumberFormatException e){
    System.err.println(e.getMessage());
}



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientId = req.getParameter("id");
        String dateInvoice = req.getParameter("date");
        String serviceInvoice = req.getParameter("service");
        String serviceQuantityInvoice = req.getParameter("serviceQuantity");
        String priceHTInvoice = req.getParameter("priceHT");
        String priceTTCInvoice = req.getParameter("priceTTC");



            InvoiceEntity invoice = new InvoiceEntity();
            invoice.setDateInvoice(Date.valueOf(dateInvoice));
            invoice.setMontantHtInvoice(Integer.valueOf(priceHTInvoice));
            invoice.setMontantTtcInvoice(Integer.valueOf(priceTTCInvoice));
            invoice.setIdClient(Integer.parseInt(clientId));


            ProductDao product = new ProductDao();
            Optional<ProductEntity> productTosave = product.get(Integer.parseInt(serviceInvoice));

            if(productTosave.isPresent()){

            InvoiceProductEntity invoiceProductEntity = new InvoiceProductEntity();
            invoiceProductEntity.setProductByIdProduct(productTosave.get());
            invoiceProductEntity.setQuantity(Integer.valueOf(serviceQuantityInvoice));

            DaoInvoice daoInvoice = new DaoInvoice();
            daoInvoice.saveWithproduct(invoice, invoiceProductEntity);

            resp.sendRedirect(req.getContextPath() + "/client");
            }






    }
}
