package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class Estado implements ValueObject<String> {

    private final String estado;

    public Estado(String estado){ this.estado = estado; }

    @Override
    public String value(){ return estado;}

}
