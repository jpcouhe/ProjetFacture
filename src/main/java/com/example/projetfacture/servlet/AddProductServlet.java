package com.example.projetfacture.servlet;

import com.example.projetfacture.dao.ClientDao;
import com.example.projetfacture.dao.ProductDao;
import com.example.projetfacture.models.ClientEntity;
import com.example.projetfacture.models.ProductEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/product/add")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/form-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("description");
        String productPriceHT = request.getParameter("price");
        String productTva = request.getParameter("tva");


        ProductEntity product = new ProductEntity();

        product.setDescriptionProduct(productDescription);
        product.setPriceHtProduct(Integer.valueOf(productPriceHT));
        product.setIdTva(Integer.valueOf(productTva));

        ProductDao productDao = new ProductDao();
        productDao.save(product);

        response.sendRedirect(request.getContextPath() + "/client");
    }
}
