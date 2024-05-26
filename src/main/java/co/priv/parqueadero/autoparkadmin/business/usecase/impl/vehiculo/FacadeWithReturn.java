package co.priv.parqueadero.autoparkadmin.business.usecase.impl.vehiculo;

public interface FacadeWithReturn<T, K> {
	
	K execute(T dto);

}
