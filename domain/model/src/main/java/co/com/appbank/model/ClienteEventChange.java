package co.com.appbank.model;




import co.com.appbank.model.entitys.Cuenta;
import co.com.appbank.model.entitys.Transaccion;
import co.com.appbank.model.events.ClienteCreado;
import co.com.appbank.model.events.CuentaAgregada;
import co.com.appbank.model.events.CuentaEliminada;
import co.com.appbank.model.generic.EventChange;
import co.com.appbank.model.values.*;

import java.util.ArrayList;
import java.util.HashSet;

public class ClienteEventChange extends EventChange {

    public ClienteEventChange(Cliente cliente){
        apply((ClienteCreado event)->{
            cliente.nombre = new Nombre(event.getNombre());
            cliente.apellido = new Apellido(event.getApellido());
            cliente.correo = new Correo(event.getCorreo());
            cliente.telefono = new Telefono(event.getTelefono());
            cliente.cuentas = new ArrayList<>();
        });

        apply((CuentaAgregada event)->{
            Cuenta cuenta = new Cuenta(CuentaId.of(String.valueOf(event.getCuentaId())),
                    new ClienteId(event.getClienteId()),
                    new FechaCreacionCuenta(event.getFechaCreacionCuenta()),
                    new TipoCuenta(event.getTipoCuenta()),
                    new Saldo(event.getSaldo()));
            cliente.cuentas.add(cuenta);
        });

        apply((CuentaEliminada event)->{
            cliente.quitarCuentaCliente(event.getClienteId(),event.getCuentaId());
            cliente.cuentas.remove(event.getCuentaId());
        });
    }


}
