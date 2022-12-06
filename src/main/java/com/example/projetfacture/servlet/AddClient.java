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

@WebServlet(urlPatterns = AddClient.URL)
public class AddClient extends HttpServlet {

    public static final String URL = "/client/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/WEB-INF/form-client.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String clientAdress = request.getParameter("clientAdress");
        String clientName = request.getParameter("clientName");
        String clientTel = request.getParameter("clientTel");
        String clientEmail = request.getParameter("clientEmail");
        String clientPostalCode = request.getParameter("clientPostalCode");
        String clientCity = request.getParameter("clientCity");


        ClientEntity client =
                new ClientEntity(
                        clientAdress,
                        clientName,
                        clientTel,
                        clientEmail,
                        Integer.parseInt(clientPostalCode),
                        clientCity,
                        1
                );
        ClientDao clientDao = new ClientDao();
        clientDao.save(client);

        resp.sendRedirect(request.getContextPath() + "/client");
    }
}