package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class TipoCuenta implements ValueObject<String> {

    private final String tipoDeCuenta;
    public TipoCuenta(String tipoDeCuenta) { this.tipoDeCuenta = tipoDeCuenta; }

    @Override
    public String value() { return tipoDeCuenta; }
}
