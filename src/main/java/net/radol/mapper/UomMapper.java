package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.UomDTO;
import net.radol.model.Uom;

@Mapper(componentModel = "spring")
	public interface UomMapper extends EntityMapper<UomDTO, Uom> {
		

	}
