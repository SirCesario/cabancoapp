package co.com.appbank.api.userdto;

import co.com.appbank.model.events.ClienteCreado;

import java.io.Serializable;


public class ClienteCreadoDto implements Serializable {

    private String clienteId;
    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    public ClienteCreadoDto(ClienteCreado clienteCreado){
        this.clienteId = clienteCreado.getClienteId().toString();
        this.nombre = clienteCreado.getNombre().value();
        this.apellido = clienteCreado.getApellido().value();
        this.correo = clienteCreado.getCorreo().value();
        this.telefono = clienteCreado.getTelefono().value();
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
