package com.example.projetfacture.servlet;

import com.example.projetfacture.dao.ClientDao;
import com.example.projetfacture.models.ClientEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "DeleteClientServlet", value = "/deleteClient")
public class DeleteClientServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            int id = Integer.parseInt(idStr);
            ClientDao clientDao = new ClientDao();
            Optional<ClientEntity> client = clientDao.get(id);

            if (client.isPresent()) {
                clientDao.delete(client.get());
                resp.sendRedirect(req.getContextPath() + "/client");
            } else {
                System.out.println("Aucun client");
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

    }
}
