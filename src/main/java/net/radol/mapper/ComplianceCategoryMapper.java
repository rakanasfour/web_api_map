package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.ComplianceCategoryDTO;
import net.radol.model.ComplianceCategory;

@Mapper(componentModel = "spring")
	public interface ComplianceCategoryMapper extends EntityMapper<ComplianceCategoryDTO, ComplianceCategory> {
		

	}
