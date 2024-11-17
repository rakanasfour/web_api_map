package net.radol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.radol.dto.AttributeDTO;
import net.radol.dto.ItemDTO;
import net.radol.dto.ItemSalesCategoryDTO;
import net.radol.model.ItemAttribute;
import net.radol.model.ItemSalesCategory;


	@Mapper(componentModel = "spring", uses= {ItemMapper.class, SalesCategoryMapper.class })
	public interface ItemSalesCategoryMapper extends EntityMapper<ItemSalesCategoryDTO, ItemSalesCategory> {
		
		
		@Mapping(source = "itemSalesCategoryId", target = "itemSalesCategoryId")
		@Mapping(source = "itemId", target = "mappedItemSales.itemId")
		 @Mapping(source = "salesCategoryId", target = "mappedSalesCategory.attributeId")
		ItemSalesCategory toEntity(ItemSalesCategoryDTO dto);
	
		 
		ItemSalesCategoryDTO toDTO(ItemSalesCategory entity);
		
		 
		 
		 ItemDTO toItemDTO(ItemSalesCategory itemSalesCategory);
		  
			@Mapping(source = "mappedSalesCategory.salesCategoryId", target = "salesCategoryId")
			@Mapping(source = "mappedSalesCategory.salesCategoryName", target = "salesCategoryName")
			 @Mapping(source = "mappedSalesCategory.salesCategoryMeasurementType", target = "salesCategoryMeasurementType")
			 @Mapping(source = "mappedSalesCategory.salesCategorySystemMeasurement", target = "salesCategorySystemMeasurement")
			
		    AttributeDTO toSalesCategoryDTO(ItemAttribute itemAttribute);
		

	}

	
	



	