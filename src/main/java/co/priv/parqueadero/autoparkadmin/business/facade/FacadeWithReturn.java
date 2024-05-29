package co.priv.parqueadero.autoparkadmin.business.facade;

public interface FacadeWithReturn<T, K>{
	
	K execute(T dto);
	
}
