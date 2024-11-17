package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.ManufacturerFacilityDTO;
import net.radol.model.ManufacturerFacility;

	@Mapper(componentModel = "spring")
	public interface ManufacturerFacilityMapper extends EntityMapper<ManufacturerFacilityDTO, ManufacturerFacility> {
		

	}
