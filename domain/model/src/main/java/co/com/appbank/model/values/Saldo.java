package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class Saldo implements ValueObject<String> {

    private final String saldoCuenta;
    public Saldo(String saldoCuenta) { this.saldoCuenta = String.valueOf(saldoCuenta); }

    @Override
    public String value() { return saldoCuenta; }
}
