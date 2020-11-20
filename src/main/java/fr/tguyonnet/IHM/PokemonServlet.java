package fr.tguyonnet.IHM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PokemonServlet", urlPatterns = {"/PokemonServlet"})
public class PokemonServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("qsdljqsndjkqs");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Pokemon.jsp");
        rd.forward(request, response);
    }
}
