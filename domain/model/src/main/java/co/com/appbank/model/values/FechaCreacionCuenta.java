package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class FechaCreacionCuenta implements ValueObject<String> {

    private final String fechaCreacionCuenta;

    public FechaCreacionCuenta(String fechaCreacionCuenta){ this.fechaCreacionCuenta = fechaCreacionCuenta; }

    @Override
    public String value() { return fechaCreacionCuenta; }
}
