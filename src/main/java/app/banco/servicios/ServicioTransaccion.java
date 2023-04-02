package app.banco.servicios;

import app.banco.entidades.Transaccion;
import app.banco.entidades.abstractas.CuentaBancaria;
import app.banco.repositorios.CuentaBaseDatos;
import app.banco.repositorios.TransaccionBaseDatos;
import app.banco.repositorios.interfaces.RepositorioCRUD;
import app.banco.servicios.interfaces.Servicio;

import java.util.List;
import java.util.Map;

public class ServicioTransaccion implements Servicio {
    private RepositorioCRUD repositorioTransaccion;
    private RepositorioCRUD repositorioCuenta;

    public ServicioTransaccion() {
        repositorioTransaccion = new TransaccionBaseDatos();
        repositorioCuenta = new CuentaBaseDatos();
    }

    @Override
    public Object Crear(Map datosTransaccion) {
        String tipoTransaccion = (String) datosTransaccion.get("tipoTransaccion");
        double monto = (double) datosTransaccion.get("monto");
        String numeroCuenta = (String) datosTransaccion.get("numeroCuenta");
        String tipoCuentaDestino = (String) datosTransaccion.get("tipoCuentaDestino");

        // Validamos los campos
        if(tipoTransaccion == null || tipoTransaccion == "" ||
                monto <= 0 ||
                numeroCuenta == null || numeroCuenta == "" ||
                tipoCuentaDestino == null || tipoCuentaDestino   == "")
        {
            throw new RuntimeException("No se enviaron todos los campos");
        }

        CuentaBancaria cuenta = (CuentaBancaria) repositorioCuenta.ObtenerUno(numeroCuenta);

        if(cuenta == null) {
            throw new RuntimeException("La cuenta indicada no existe");
        }

        Transaccion transaccion = new Transaccion(tipoTransaccion, monto, cuenta.getId(), tipoCuentaDestino);

        return repositorioTransaccion.Crear(transaccion);
    }

    @Override
    public Object ObtenerUno(Object id) {
        return repositorioTransaccion.ObtenerUno(id);
    }

    @Override
    public List<?> ListarTodos() {
        return repositorioTransaccion.ListarTodos();
    }

    @Override
    public String Eliminar(Object idTransaccion) {

        Transaccion transaccionAEliminar = (Transaccion) repositorioTransaccion.ObtenerUno(idTransaccion);

        if(transaccionAEliminar == null){
            throw new RuntimeException("La transaccion indicada no existe");
        }

        return repositorioTransaccion.Eliminar(transaccionAEliminar);
    }
}
