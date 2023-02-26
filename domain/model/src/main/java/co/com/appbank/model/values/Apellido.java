package co.com.appbank.model.values;


import co.com.appbank.model.generic.ValueObject;

public class Apellido implements ValueObject<String> {

    private final String apellido;
    public Apellido(String apellido) {this.apellido = apellido;}

    @Override
    public String value(){ return apellido;}
}
