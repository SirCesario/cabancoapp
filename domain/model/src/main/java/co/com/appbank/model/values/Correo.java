package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class Correo implements ValueObject<String> {
    private final String correo;
    public Correo(String correo){ this.correo = correo; }

    @Override
    public String value(){ return correo;}
}
