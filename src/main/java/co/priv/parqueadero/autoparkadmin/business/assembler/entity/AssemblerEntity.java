package co.priv.parqueadero.autoparkadmin.business.assembler.entity;

import co.priv.parqueadero.autoparkadmin.business.assembler.Assembler;

public interface AssemblerEntity<D, X> extends Assembler<D, X> {

	X toEntity(D domain);
}
