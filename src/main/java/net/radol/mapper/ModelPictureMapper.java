package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.ModelPictureDTO;
import net.radol.model.ModelPicture;

@Mapper(componentModel = "spring")
	public interface ModelPictureMapper extends EntityMapper<ModelPictureDTO, ModelPicture> {
		

	}
