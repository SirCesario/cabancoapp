package co.com.appbank.usecase.command;


import co.com.appbank.usecase.generic.Command;

public class AgregarCuentaClienteCommand extends Command {

    private String clienteId;
    private String cuentaId;
    private String fechaCreacionCuenta;
    private String tipoCuenta;
    private String saldo;

    public AgregarCuentaClienteCommand(){

    }

    public AgregarCuentaClienteCommand(String clienteId, String cuentaId, String fechaCreacionCuenta, String tipoCuenta, String saldo) {
        this.clienteId = clienteId;
        this.cuentaId = cuentaId;
        this.fechaCreacionCuenta = fechaCreacionCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getCuentaId() {
        return cuentaId;
    }

    public String getFechaCreacionCuenta() {
        return fechaCreacionCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public String getSaldo() {
        return saldo;
    }
}
