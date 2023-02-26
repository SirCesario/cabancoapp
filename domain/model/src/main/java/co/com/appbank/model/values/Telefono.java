package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class Telefono implements ValueObject<String> {

    private final String telefono;
    public Telefono(String telefono) { this.telefono = telefono; }

    @Override
    public String value() { return telefono; }
}
