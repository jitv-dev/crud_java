package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import models.dao.EmpleadoDAO;

import java.io.IOException;

@WebServlet("/EmpleadoController")
public class EmpleadoController extends HttpServlet {

    private EmpleadoDAO empDao = new EmpleadoDAO();
    private final String pagListar = "/views/listar.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        if (accion == null) accion = "listar";

        switch (accion){
            case "listar":
                listar(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("empleados", empDao.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}