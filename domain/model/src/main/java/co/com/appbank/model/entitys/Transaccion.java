package co.com.appbank.model.entitys;


import co.com.appbank.model.generic.Entity;
import co.com.appbank.model.values.*;

public class Transaccion extends Entity<TransaccionId> {


    private CuentaId cuentaId;
    private FechaTransaccion fechaTransaccion;
    private ValorTransaccion valorTransaccion;
    private Estado estado;

    public Transaccion(TransaccionId transaccionId, CuentaId cuentaId, FechaTransaccion fechaTransaccion, ValorTransaccion valorTransaccion, Estado estado) {
        super(transaccionId);
        this.cuentaId = cuentaId;
        this.fechaTransaccion = fechaTransaccion;
        this.valorTransaccion = valorTransaccion;
        this.estado = estado;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public FechaTransaccion getFechaTransaccion() {
        return fechaTransaccion;
    }

    public ValorTransaccion getValorTransaccion() {
        return valorTransaccion;
    }

    public Estado getEstado() {
        return estado;
    }
}


