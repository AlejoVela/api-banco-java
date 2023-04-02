package app.banco.entidades;

import app.banco.entidades.abstractas.CuentaBancaria;

public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(String numeroCuenta, String tipoCuenta, int idUsuario) {
        super(numeroCuenta, tipoCuenta, idUsuario);
    }

    @Override
    public double depositar(double depositoDinero) {
        this.saldo += depositoDinero;
        numeroDepositos++;
        return this.saldo;
    }

    @Override
    public double retirar(double retiroDinero) {
        if (retiroDinero <= this.saldo && this.numeroRetiros <= 5) {
            System.out.println("Por favor espere mientras se realiza la transacción");
            this.saldo -= retiroDinero;
            numeroRetiros++;
        }else {
            throw new IllegalArgumentException("Transacción errada por saldo insuficienteo o limite de retiros superados");
        }
        return this.saldo;
    }

    @Override
    public void imprimirCuentaBancaria(){
        int numeroTransacciones = this.numeroDepositos + this.numeroRetiros;
        System.out.println("CUENTA CORRIENTE" + "\n" +
                "Saldo: " + this.saldo + "\n" +
                "Consignaciones: " + numeroDepositos + "\n" +
                "Retiros: " + numeroRetiros + "\n" +
                "Transacciones realizadas: " + numeroTransacciones);
    }

}