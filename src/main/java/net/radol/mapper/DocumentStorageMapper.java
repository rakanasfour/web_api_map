package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.DocumentStorageDTO;
import net.radol.model.DocumentStorage;

@Mapper(componentModel = "spring")
	public interface DocumentStorageMapper extends EntityMapper<DocumentStorageDTO, DocumentStorage> {
		

	}
