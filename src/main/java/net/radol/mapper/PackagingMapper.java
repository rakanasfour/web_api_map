package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.PackagingDTO;
import net.radol.model.Packaging;

@Mapper(componentModel = "spring")
	public interface PackagingMapper extends EntityMapper<PackagingDTO, Packaging> {
		

	}
