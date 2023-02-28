package co.com.appbank.usecase.command;


import co.com.appbank.usecase.generic.Command;

public class ClienteCreadoCommand extends Command {

    private String clienteId;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String cuentaId;


    public ClienteCreadoCommand(){}

    public ClienteCreadoCommand(String clienteId, String nombre, String apellido, String correo, String telefono, String cuentaId) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.cuentaId = cuentaId;

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

    public String getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
    }
}
