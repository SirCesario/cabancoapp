package co.com.appbank.model;




import co.com.appbank.model.entitys.Cuenta;
import co.com.appbank.model.entitys.Transaccion;
import co.com.appbank.model.events.ClienteActualizado;
import co.com.appbank.model.events.ClienteCreado;
import co.com.appbank.model.events.CuentaAgregada;
import co.com.appbank.model.events.CuentaEliminada;
import co.com.appbank.model.generic.EventChange;
import co.com.appbank.model.values.*;

import java.util.HashSet;

public class ClienteEventChange extends EventChange {

    public ClienteEventChange(Cliente cliente){
        apply((ClienteCreado event)->{
            cliente.nombre = event.getNombre();
            cliente.apellido = event.getApellido();
            cliente.correo = event.getCorreo();
            cliente.telefono = event.getTelefono();
            cliente.cuentas = new HashSet<>();
        });

        apply((CuentaAgregada event)->{
            Cuenta cuenta = new Cuenta(event.getCuentaId(),event.getClienteId(),event.getFechaCreacionCuenta(),
                    event.getTipoCuenta(),event.getSaldo(),new HashSet<Transaccion>());
            cliente.cuentas.add(cuenta);
        });

        apply((ClienteActualizado event) -> {
            ClienteId clienteId = ClienteId.of(event.getClienteId().toString());
            Nombre nombre = new Nombre(event.getNombre().toString());
            Apellido apellido = new Apellido(event.getApellido().toString());
            Correo correo = new Correo(event.getCorreo().toString());
            Telefono telefono = new Telefono(event.getTelefono().toString());
            cliente.actualizarCliente(clienteId, nombre, apellido, correo, telefono);
        });

        apply((CuentaEliminada event)->{
            cliente.quitarCuentaCliente(event.getClienteId(),event.getCuentaId());
            cliente.cuentas.remove(event.getCuentaId());
        });
    }


}
