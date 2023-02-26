package co.com.appbank.model.command;


import co.com.appbank.model.generic.Command;

public class QuitarCuentaClienteCommand extends Command {

    private String clienteId;
    private String cuentaId;

    public QuitarCuentaClienteCommand(){
    }

    public QuitarCuentaClienteCommand(String clienteId, String cuentaId) {
        this.clienteId = clienteId;
        this.cuentaId = cuentaId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
    }
}
