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


@WebServlet(name = "EditClientServlet", value = "/client/edit")
public class EditClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        try{

        int id = Integer.parseInt(idStr);
        ClientDao clientDao = new ClientDao();
        Optional<ClientEntity> client = clientDao.get(id);

        if(client.isPresent()){
            req.setAttribute("client", client.get());
            req.getRequestDispatcher("/WEB-INF/form-client.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idToUpd = req.getParameter("id");
            int id = Integer.parseInt(idToUpd);
            System.out.println(id);
            ClientDao dao = new ClientDao();
            Optional<ClientEntity> client = dao.get(id);

            if (client.isPresent()) {

                client.get().setAdressClient(req.getParameter("clientAdress"));
                client.get().setNameClient(req.getParameter("clientName"));
                client.get().setTelClient(req.getParameter("clientTel"));
                client.get().setEmailClient(req.getParameter("clientEmail"));
                client.get().setPostalCodeClient(Integer.valueOf(req.getParameter("clientPostalCode")));
                client.get().setCityClient(req.getParameter("clientCity"));

                dao.update(client.get());
                resp.sendRedirect(req.getContextPath() + "/client");
            } else {
                System.out.println("Aucun client n'a été trouvé");
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }
}
