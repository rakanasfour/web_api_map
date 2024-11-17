package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.UomPictureDTO;
import net.radol.model.UomPicture;

@Mapper(componentModel = "spring")
	public interface UomPictureMapper extends EntityMapper<UomPictureDTO, UomPicture> {
		

	}
