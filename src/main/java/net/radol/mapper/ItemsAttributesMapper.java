package net.radol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.radol.dto.AttributeDTO;
import net.radol.dto.ItemAttributeDTO;
import net.radol.dto.ItemDTO;
import net.radol.model.ItemAttribute;



@Mapper(componentModel = "spring", uses= {ItemMapper.class, SalesCategoryMapper.class })
public interface ItemsAttributesMapper extends EntityMapper<ItemAttributeDTO, ItemAttribute> {
	
	
	@Mapping(source = "itemAttributeId", target = "itemAttributeId")
	@Mapping(source = "itemId", target = "mappedItem.itemId")
	 @Mapping(source = "attributeId", target = "mappedAttribute.attributeId")
	ItemAttribute toEntity(ItemAttributeDTO dto);

	 
	ItemAttributeDTO toDTO(ItemAttribute entity);
	
	 
	 
	 ItemDTO toItemDTO(ItemAttribute itemAttribute);
	  
		@Mapping(source = "mappedAttribute.attributeId", target = "attributeId")
		@Mapping(source = "mappedAttribute.attributeName", target = "attributeName")
		 @Mapping(source = "mappedAttribute.attributeType", target = "attributeType")
		 @Mapping(source = "mappedAttribute.attributeAssistText", target = "attributeAssistText")
		
	    AttributeDTO toSalesCategoryDTO(ItemAttribute itemAttribute);
	

}