package co.com.appbank.model.values;


import co.com.appbank.model.generic.Identity;

public class CuentaId extends Identity {

    public CuentaId(String cuentaId){super(cuentaId);}
    public CuentaId(){

    }

    public static CuentaId of(String cuentaId){ return new CuentaId(cuentaId); }
}
