package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import models.Empleado;
import models.dao.EmpleadoDAO;

import java.io.IOException;

@WebServlet("/EmpleadoController")
public class EmpleadoController extends HttpServlet {

    private EmpleadoDAO empDao = new EmpleadoDAO();
    private final String pagListar = "/views/listar.jsp";
    private final String pagNuevo = "/views/nuevo.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        if (accion == null) accion = "listar";

        switch (accion) {
            case "listar":
                listar(request, response);
                break;
            case "nuevo":
                nuevo(request, response);
                break;
            case "guardar":
                guardar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
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

    protected void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("empleados", new Empleado());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Empleado obj = new Empleado();
        obj.setNombres(request.getParameter("nombres"));
        obj.setApellidos(request.getParameter("apellidos"));
        obj.setFechaIngreso(request.getParameter("fechaIngreso"));
        obj.setSueldo(Double.parseDouble(request.getParameter("sueldo")));

        int result = empDao.registrar(obj);

        if (result > 0) {
            response.sendRedirect("EmpleadoController?accion=listar");
        } else {
            request.setAttribute("empleado", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Empleado obj = new Empleado();
        obj.setNombres(request.getParameter("nombres"));
        obj.setApellidos(request.getParameter("apellidos"));
        obj.setFechaIngreso(request.getParameter("fechaIngreso"));
        obj.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
        obj.setId(Integer.parseInt(request.getParameter("id")));

        int result = empDao.actualizar(obj);

        if (result > 0) {
            response.sendRedirect("EmpleadoController?accion=listar");
        } else {
            request.setAttribute("empleado", obj);
            request.getRequestDispatcher(pagListar).forward(request, response);
        }
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        int result = empDao.eliminar(id);

        if (result > 0) {
            response.sendRedirect("EmpleadoController?accion=listar");
        } else {
            request.getRequestDispatcher(pagListar).forward(request, response);
        }
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