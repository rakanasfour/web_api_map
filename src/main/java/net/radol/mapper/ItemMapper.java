package net.radol.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.radol.dto.AttributeDTO;
import net.radol.dto.ItemDTO;
import net.radol.model.Attribute;
import net.radol.model.Item;


@Mapper(componentModel = "spring")
	public interface ItemMapper extends EntityMapper<ItemDTO, Item> {
		


	@Mapping(source = "itemId", target = "attributeId")
	@Mapping(source = "itemName", target = "attributeName")
	 @Mapping(source = "itemSku", target = "attributeType")
	 @Mapping(source = "itemDescription", target = "attributeAssistText")
	 @Mapping(source = "itemType", target = "itemAttributes")
	@Mapping(source = "itemQuantity", target = "attributeId")
	@Mapping(source = "itemAvailability", target = "attributeName")
	 @Mapping(source = "itemMsaPromoItem", target = "attributeType")
	 @Mapping(source = "itemBasePrice", target = "attributeAssistText")
	 @Mapping(source = "itemWeight", target = "itemAttributes")
	@Mapping(source = "itemUpdatedAt", target = "attributeId")
	@Mapping(source = "itemUpdatedAtBy", target = "attributeName")
	 @Mapping(source = "itemStatus", target = "attributeType")
	 @Mapping(source = "manufacturerPricing", target = "attributeAssistText")
	 @Mapping(source = "distributor", target = "itemAttributes")
	@Mapping(source = "model", target = "attributeId")
	@Mapping(source = "complianceCategory", target = "attributeName")
	 @Mapping(source = "itemMsaPromoItem", target = "attributeType")
	 @Mapping(source = "itemBasePrice", target = "attributeAssistText")
	 @Mapping(source = "itemWeight", target = "itemAttributes")
	 @Mapping(source = "itemAttributes", target = "itemAttributes")
	Item toEntity(ItemDTO dto);

	 @InheritInverseConfiguration
	 ItemDTO toDTO(Item entity);

	
}
    	