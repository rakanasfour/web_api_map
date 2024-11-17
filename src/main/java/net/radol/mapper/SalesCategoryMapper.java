package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.SalesCategoryDTO;
import net.radol.model.SalesCategory;

@Mapper(componentModel = "spring")
	public interface SalesCategoryMapper extends EntityMapper<SalesCategoryDTO, SalesCategory> {
		

	}
