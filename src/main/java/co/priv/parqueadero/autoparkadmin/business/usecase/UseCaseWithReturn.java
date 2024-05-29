package co.priv.parqueadero.autoparkadmin.business.usecase;

public interface UseCaseWithReturn<T,R> {
	
	R execute(T data);

}
