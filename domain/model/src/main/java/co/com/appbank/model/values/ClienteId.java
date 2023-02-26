package co.com.appbank.model.values;


import co.com.appbank.model.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId(String clienteId){super(clienteId);}

    public ClienteId(){ }

    public static ClienteId of(String clienteId) { return new ClienteId(clienteId);}
}
