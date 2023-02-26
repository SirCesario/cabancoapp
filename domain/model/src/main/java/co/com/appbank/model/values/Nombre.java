package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class Nombre implements ValueObject<String> {

    private final String nombre;

    public Nombre(String nombre) { this.nombre = nombre; }

    @Override
    public String value() { return nombre; }
}
