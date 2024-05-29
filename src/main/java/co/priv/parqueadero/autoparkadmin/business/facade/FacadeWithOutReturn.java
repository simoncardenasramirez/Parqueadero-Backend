package co.priv.parqueadero.autoparkadmin.business.facade;

public interface FacadeWithOutReturn<T> {
	
	void execute(T dto);

}
