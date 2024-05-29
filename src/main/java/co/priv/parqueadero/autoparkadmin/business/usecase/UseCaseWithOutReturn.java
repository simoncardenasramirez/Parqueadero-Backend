package co.priv.parqueadero.autoparkadmin.business.usecase;

public interface UseCaseWithOutReturn<T> {
	
	void execute(T data);

}