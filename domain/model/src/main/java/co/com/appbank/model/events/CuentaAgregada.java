package co.com.appbank.model.events;


import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.model.values.*;

public class CuentaAgregada extends DomainEvent {

    private String clienteId;
    private String cuentaId;
    private String fechaCreacionCuenta;
    private String tipoCuenta;
    private String saldo;

    public CuentaAgregada(){
        super("Se agrego la cuenta");
    }

    public CuentaAgregada(String cuentaId, String clienteId, String fechaCreacionCuenta, String tipoCuenta, String saldo) {
        super("Cuenta Agregada con Exito");
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.fechaCreacionCuenta = fechaCreacionCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getCuentaId() {
        return cuentaId;
    }

    public String getFechaCreacionCuenta() {
        return fechaCreacionCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public String getSaldo() {
        return saldo;
    }
}
