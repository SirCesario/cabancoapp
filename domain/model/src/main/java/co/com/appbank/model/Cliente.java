package co.com.appbank.model;




import co.com.appbank.model.entitys.Cuenta;
import co.com.appbank.model.events.ClienteActualizado;
import co.com.appbank.model.events.ClienteCreado;
import co.com.appbank.model.events.CuentaAgregada;
import co.com.appbank.model.events.CuentaEliminada;
import co.com.appbank.model.generic.AggregateRoot;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.model.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Cliente extends AggregateRoot<ClienteId> {


    protected Nombre nombre;
    protected Apellido apellido;
    protected Correo correo;
    protected Telefono telefono;
    protected Set<Cuenta> cuentas;

    public Cliente(ClienteId id, Nombre nombre,Apellido apellido,Correo correo,Telefono telefono){
        super(id);
        subscribe(new ClienteEventChange(this));
        appendChange(new ClienteCreado(id,nombre,apellido,correo,telefono)).apply();
    }

    public static Cliente from(ClienteId clienteId, List<DomainEvent>events){
        Cliente cliente = new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public Cliente(ClienteId id){
        super(id);
        subscribe(new ClienteEventChange(this));
    }

    public void agregarCuenta(CuentaId id, ClienteId clienteId, FechaCreacionCuenta fechaCreacionCuenta, TipoCuenta tipoCuenta,Saldo saldo){
        Objects.requireNonNull(id);
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(fechaCreacionCuenta);
        Objects.requireNonNull(tipoCuenta);
        Objects.requireNonNull(saldo);
        appendChange(new CuentaAgregada(id,clienteId,fechaCreacionCuenta,tipoCuenta,saldo)).apply();
    }

    public void actualizarCliente(ClienteId id,Nombre nombre,Apellido apellido,Correo correo,Telefono telefono){
        Objects.requireNonNull(id);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(apellido);
        Objects.requireNonNull(correo);
        Objects.requireNonNull(telefono);
        appendChange(new ClienteActualizado(id,nombre,apellido,correo,telefono)).apply();
    }

    public void quitarCuentaCliente(ClienteId id,CuentaId cuentaId){
        Objects.requireNonNull(id);
        Objects.requireNonNull(cuentaId);
        appendChange(new CuentaEliminada(id,cuentaId)).apply();
    }

}

