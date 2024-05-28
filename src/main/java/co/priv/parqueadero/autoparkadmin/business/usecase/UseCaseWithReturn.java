package co.priv.parqueadero.autoparkadmin.business.usecase;

public interface UseCaseWithReturn<T, K> {
	
	K execute(T dto);

}
