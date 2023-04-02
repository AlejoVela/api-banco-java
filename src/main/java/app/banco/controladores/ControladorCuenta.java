package app.banco.controladores;

import app.banco.servicios.ServicioCuenta;
import app.banco.servicios.ServicioUsuario;
import app.banco.servicios.interfaces.Servicio;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControladorCuenta extends HttpServlet {
    private Servicio servicioCuenta;
    private ObjectMapper mapper;

    public ControladorCuenta() {
        servicioCuenta = new ServicioCuenta();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        switch (request.getPathInfo()) {
            case "/obtener-uno":
                // TODO: Validar que el query param sea entero (regex)
                int id = Integer.parseInt(request.getQueryString().split("=")[1]);
                response.getWriter().println("obtener uno");
                break;
            case "/listar-todos":
                response.getWriter().println("listar todos");
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encuentra el recurso");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        switch (request.getPathInfo()) {
            case "/crear":
                response.getWriter().println("crear cuenta");
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encuentra el recurso");
                break;
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        switch (request.getPathInfo()) {
            case "/eliminar":
                // TODO: Validar que el query param sea entero (regex)
                int id = Integer.parseInt(request.getQueryString().split("=")[1]);
                response.getWriter().println("eliminar cuenta " + id);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No se encuentra el recurso");
                break;
        }
    }
}
