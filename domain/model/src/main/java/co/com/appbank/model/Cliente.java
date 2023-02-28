package co.com.appbank.model;




import co.com.appbank.model.entitys.Cuenta;
import co.com.appbank.model.events.ClienteCreado;
import co.com.appbank.model.events.CuentaAgregada;
import co.com.appbank.model.events.CuentaEliminada;
import co.com.appbank.model.generic.AggregateRoot;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.model.values.*;

import java.util.List;
import java.util.Objects;

public class Cliente extends AggregateRoot<ClienteId> {


    protected Nombre nombre;
    protected Apellido apellido;
    protected Correo correo;
    protected Telefono telefono;
    protected List<Cuenta> cuentas;


    public Cliente(ClienteId entityId,
                   Nombre nombre,
                   Apellido apellido,
                   Correo correo,
                   Telefono telefono,
                   CuentaId cuentaId){
        super(entityId);
        subscribe(new ClienteEventChange(this));
        appendChange(new ClienteCreado(nombre.value(),apellido.value(),correo.value(),telefono.value(),cuentaId.value())).apply();
    }

    public static Cliente from(ClienteId id, List<DomainEvent>events){
        Cliente cliente = new Cliente(id);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    private Cliente(ClienteId id){
        super(id);
        subscribe(new ClienteEventChange(this));
    }

    public void agregarCuenta(CuentaId cuentaId, ClienteId clienteId, FechaCreacionCuenta fechaCreacionCuenta, TipoCuenta tipoCuenta,Saldo saldo){
        Objects.requireNonNull(cuentaId);
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(fechaCreacionCuenta);
        Objects.requireNonNull(tipoCuenta);
        Objects.requireNonNull(saldo);
        appendChange(new CuentaAgregada(cuentaId.value(),clienteId.value(), fechaCreacionCuenta.value(), tipoCuenta.value(),saldo.value())).apply();
    }


    public void quitarCuentaCliente(ClienteId id,CuentaId cuentaId){
        Objects.requireNonNull(id);
        Objects.requireNonNull(cuentaId);
        appendChange(new CuentaEliminada(id,cuentaId)).apply();
    }

}

