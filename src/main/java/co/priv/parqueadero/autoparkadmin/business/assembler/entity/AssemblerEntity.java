package co.priv.parqueadero.autoparkadmin.business.assembler.entity;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.Assembler;

public interface AssemblerEntity<D, K> extends Assembler<D, K> {
	
	K toEntity(D domain);
	
	List<K> toEntityCollection(List<D> domainCollection);

}
