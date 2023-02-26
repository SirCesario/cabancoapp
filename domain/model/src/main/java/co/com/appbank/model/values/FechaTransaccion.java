package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class FechaTransaccion implements ValueObject<String> {

    private String fechaTransaccion;

    public FechaTransaccion(String fechaTransaccion){ this.fechaTransaccion = fechaTransaccion ;}

    @Override
    public String value(){ return fechaTransaccion; }
}
