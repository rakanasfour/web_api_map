package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.BrandPictureDTO;
import net.radol.model.BrandPicture;

@Mapper(componentModel = "spring")
public interface BrandPictureMapper extends EntityMapper<BrandPictureDTO, BrandPicture> {
	

}
