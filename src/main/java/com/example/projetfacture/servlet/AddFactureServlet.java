package com.example.projetfacture.servlet;

import com.example.projetfacture.dao.ProductDao;
import com.example.projetfacture.models.ProductEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = AddFactureServlet.URL)
public class AddFactureServlet extends HttpServlet {
    public static final String URL = "/facture/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao product = new ProductDao();
        List<ProductEntity> productList = product.getAll();

        ;

        req.setAttribute("products", productList);

        req.getRequestDispatcher("/WEB-INF/form-facture.jsp").forward(req, resp);
    }
}
