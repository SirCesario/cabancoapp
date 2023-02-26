package co.com.appbank.model.events;


import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.model.values.*;

public class CuentaAgregada extends DomainEvent {

    private ClienteId clienteId;
    private CuentaId cuentaId;
    private FechaCreacionCuenta fechaCreacionCuenta;
    private TipoCuenta tipoCuenta;
    private Saldo saldo;

    public CuentaAgregada(CuentaId cuentaId,ClienteId clienteId, FechaCreacionCuenta fechaCreacionCuenta, TipoCuenta tipoCuenta, Saldo saldo) {
        super("Cuenta Agregada con Exito");
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.fechaCreacionCuenta = fechaCreacionCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public FechaCreacionCuenta getFechaCreacionCuenta() {
        return fechaCreacionCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public Saldo getSaldo() {
        return saldo;
    }
}
