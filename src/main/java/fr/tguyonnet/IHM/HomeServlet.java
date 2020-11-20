package fr.tguyonnet.IHM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
    private int lives = 3;
    private int number;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("number"));
        if (Integer.parseInt(request.getParameter("number")) == number) {
            // GAGNE
            request.setAttribute("win", true);
            request.setAttribute("lives", lives);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Home.jsp");
            rd.forward(request, response);
        } else {
            // PAS GAGNE
            this.lives--;
            request.setAttribute("win", false);
            request.setAttribute("lives", lives);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Home.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Home.jsp");
        rd.forward(request, response);
    }

}
