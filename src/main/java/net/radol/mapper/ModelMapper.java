package net.radol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.radol.dto.ModelDTO;

import net.radol.model.Model;

@Mapper(componentModel = "spring")
	public interface ModelMapper extends EntityMapper<ModelDTO, Model> {
	
	
	
	
	 @Mapping(source = "modelId", target = "modelId")
	 @Mapping(source = "modelName", target = "modelName")
	 @Mapping(source = "modelDescription", target = "modelDescription")
	 @Mapping(source = "brandId", target = "brand.brandId")
	 @Mapping(source = "manufacturerFacilityId", target = "manufacturerFacility.facilityId")
	 @Mapping(source = "modelPictures", target = "modelPictures")

	 Model toEntity(ModelDTO dto);

	   // @Mapping(source = "brandId", target = "brandId", qualifiedByName = "mapIdToBrand")
	 ModelDTO toDTO(Model entity);
}

