package co.priv.parqueadero.autoparkadmin.business.usecase;

public interface UseCaseWithoutReturn<T> {
	void execute(T dto);
	

}
