package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.ManufacturerPricingDTO;
import net.radol.model.ManufacturerPricing;

@Mapper(componentModel = "spring")
	public interface ManufacturerPricingMapper extends EntityMapper<ManufacturerPricingDTO, ManufacturerPricing> {
		

	}
