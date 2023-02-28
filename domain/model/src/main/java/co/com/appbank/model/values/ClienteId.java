package co.com.appbank.model.values;


import co.com.appbank.model.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId(ClienteId uuid){super(String.valueOf(uuid));}

    public ClienteId(String uuid){ }

    public static ClienteId of(String uuid) { return new ClienteId(uuid);}
}
