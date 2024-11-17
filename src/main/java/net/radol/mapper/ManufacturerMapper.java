package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.ManufacturerDTO;
import net.radol.model.Manufacturer;

@Mapper(componentModel = "spring")
	public interface ManufacturerMapper extends EntityMapper<ManufacturerDTO, Manufacturer> {
		

	}
