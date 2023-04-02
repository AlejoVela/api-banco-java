package app.banco.servicios;

import app.banco.repositorios.CuentaBaseDatos;
import app.banco.repositorios.interfaces.RepositorioCRUD;
import app.banco.servicios.interfaces.Servicio;

import java.util.List;
import java.util.Map;

public class ServicioCuenta implements Servicio {
    private RepositorioCRUD repositorio;

    public ServicioCuenta() {
        repositorio = new CuentaBaseDatos();
    }

    @Override
    public Object Crear(Map objeto) {
        return null;
    }

    @Override
    public Object ObtenerUno(Object id) {
        return null;
    }

    @Override
    public List<?> ListarTodos() {
        return null;
    }

    @Override
    public String Eliminar(Object id) {
        return null;
    }
}
