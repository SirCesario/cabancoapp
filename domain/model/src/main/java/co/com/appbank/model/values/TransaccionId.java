package co.com.appbank.model.values;


import co.com.appbank.model.generic.Identity;

public class TransaccionId extends Identity {

    private TransaccionId(String transaccionId){super(transaccionId); }

    public TransaccionId(){

    }

    public static TransaccionId of (String transaccionId){ return new TransaccionId(transaccionId); }
}
