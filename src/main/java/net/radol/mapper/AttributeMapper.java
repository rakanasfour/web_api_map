package net.radol.mapper;



import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.radol.dto.AttributeDTO;
import net.radol.model.Attribute;
import net.radol.model.ItemAttribute;

@Mapper(componentModel = "spring", uses={ItemAttribute.class})
public interface AttributeMapper extends EntityMapper<AttributeDTO, Attribute> {
	


	@Mapping(source = "attributeId", target = "attributeId")
	@Mapping(source = "attributeName", target = "attributeName")
	 @Mapping(source = "attributeType", target = "attributeType")
	 @Mapping(source = "attributeAssistText", target = "attributeAssistText")
	 @Mapping(source = "itemAttributes", target = "itemAttributes")
	Attribute toEntity(AttributeDTO dto);

	 @InheritInverseConfiguration
	AttributeDTO toDTO(Attribute entity);

	
    
    	

	
	
}
