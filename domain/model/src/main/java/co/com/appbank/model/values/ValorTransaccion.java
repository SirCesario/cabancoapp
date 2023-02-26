package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class ValorTransaccion implements ValueObject<String> {

    private String valorTransaccion;

    public ValorTransaccion(String valorTransaccion){ this.valorTransaccion = valorTransaccion; }

    @Override
    public String value(){ return valorTransaccion;}

}
