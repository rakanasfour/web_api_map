package net.radol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.radol.dto.ChannelDTO;
import net.radol.dto.ItemChannelDTO;
import net.radol.dto.ItemDTO;
import net.radol.model.ItemAttribute;
import net.radol.model.ItemChannel;
import net.radol.model.ItemSalesCategory;

@Mapper(componentModel = "spring", uses= {ItemMapper.class, SalesCategoryMapper.class })
public interface ItemsChannelsMapper extends EntityMapper<ItemChannelDTO, ItemChannel> {
	
	
	@Mapping(source = "itemChannelId", target = "itemChannelId")
	@Mapping(source = "mappedItemChannelId", target = "mappedItemChannel.itemId")
	 @Mapping(source = "mappedChannelId", target = "mappedChannel.channelId")
	ItemChannel toEntity(ItemChannelDTO dto);

	 
	ItemChannelDTO toDTO(ItemSalesCategory entity);
	
	 
	 
	 ItemDTO toItemDTO(ItemSalesCategory itemSalesCategory);
	  
		@Mapping(source = "mappedItemChannel.channelId", target = "channelId")
		@Mapping(source = "mappedItemChannel.channelDescription", target = "channelDescription")
		 @Mapping(source = "mappedItemChannel.channelsLevel", target = "channelsLevel")
		 @Mapping(source = "mappedItemChannel.channelDefaultUom", target = "channelDefaultUom")
		
		ChannelDTO toChannelDTO(ItemAttribute itemAttribute);
	

}