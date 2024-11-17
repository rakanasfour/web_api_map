package net.radol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.radol.dto.AttributeDTO;
import net.radol.dto.ItemDTO;
import net.radol.dto.ItemUOMDTO;
import net.radol.model.ItemAttribute;
import net.radol.model.ItemSalesCategory;
import net.radol.model.ItemUOM;

@Mapper(componentModel = "spring", uses= {ItemMapper.class, SalesCategoryMapper.class })
	public interface ItemUOMMapper extends EntityMapper<ItemUOMDTO, ItemUOM> {
		
		
		@Mapping(source = "itemUomId", target = "itemUomId")
		@Mapping(source = "mappedItemUomId", target = "mappedItemUom.itemId")
		 @Mapping(source = "mappedUomItemId", target = "mappedUomItem.uomId")
		ItemUOM toEntity(ItemUOMDTO dto);
	
		 
		ItemUOMDTO toDTO(ItemSalesCategory entity);
		
		 
		 
		 ItemDTO toItemDTO(ItemSalesCategory itemUOM);
			@Mapping(source = "mappedUomItem.uomId", target = "uomId")
			@Mapping(source = "mappedUomItem.uomType", target = "uomType")
			 @Mapping(source = "mappedUomItem.uomLevel", target = "uomLevel")
			 @Mapping(source = "mappedUomItem.uomStatus", target = "uomStatus")
			
		    AttributeDTO toSalesCategoryDTO(ItemAttribute itemAttribute);
		
	
	}
	
