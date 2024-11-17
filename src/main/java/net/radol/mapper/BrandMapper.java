package net.radol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import net.radol.dto.BrandDTO;

import net.radol.model.Brand;

@Mapper(componentModel = "spring")
	public interface BrandMapper extends EntityMapper<BrandDTO, Brand> {
		
		 @Mapping(source = "brandId", target = "brandId")
		 @Mapping(source = "brandName", target = "brandName")
		 @Mapping(source = "brandDescription", target = "brandDescription")
		 @Mapping(source = "brandStatus", target = "brandStatus")
		 @Mapping(source = "manufacturerId", target = "manufacturer.manufacturerId")

		 Brand toEntity(BrandDTO dto);
		 @Mapping(source = "brandId", target = "brandId")
		   // @Mapping(source = "brandId", target = "brandId", qualifiedByName = "mapIdToBrand")
		 BrandDTO toDTO(Brand entity);
	}
