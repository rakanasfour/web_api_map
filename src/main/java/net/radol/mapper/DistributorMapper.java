package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.DistributorDTO;
import net.radol.model.Distributor;

@Mapper(componentModel = "spring")
	public interface DistributorMapper extends EntityMapper<DistributorDTO, Distributor> {
		

	}
