package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.ItemPictureDTO;
import net.radol.model.ItemPicture;

@Mapper(componentModel = "spring")
	public interface ItemPictureMapper extends EntityMapper<ItemPictureDTO, ItemPicture> {
		

	}
