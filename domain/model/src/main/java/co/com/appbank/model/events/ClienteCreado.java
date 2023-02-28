package co.com.appbank.model.events;


import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.model.values.*;

public class ClienteCreado extends DomainEvent {


    private  String nombre;
    private  String apellido;
    private  String correo;
    private  String telefono;
    private  String cuentaId;

    public ClienteCreado(){
        super("Cliente Creado");
    }



    public ClienteCreado(String nombre, String apellido, String correo, String telefono,String cuentaId) {
        super("Cliente Creado");
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.cuentaId = cuentaId;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCuentaId() {
        return cuentaId;
    }
}
