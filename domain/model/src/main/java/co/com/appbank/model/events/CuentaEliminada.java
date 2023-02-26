package co.com.appbank.model.events;


import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.model.values.ClienteId;
import co.com.appbank.model.values.CuentaId;

public class CuentaEliminada extends DomainEvent {

    private final ClienteId clienteId;
    private final CuentaId cuentaId;

    public CuentaEliminada( ClienteId clienteId, CuentaId cuentaId) {
        super("Cuenta Eliminada Correctamente");
        this.clienteId = clienteId;
        this.cuentaId = cuentaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
