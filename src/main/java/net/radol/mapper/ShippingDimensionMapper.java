package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.ShippingDimensionDTO;
import net.radol.model.ShippingDimension;

@Mapper(componentModel = "spring")
	public interface ShippingDimensionMapper extends EntityMapper<ShippingDimensionDTO, ShippingDimension> {
		

	}
