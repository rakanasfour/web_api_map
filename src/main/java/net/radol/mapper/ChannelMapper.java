package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.ChannelDTO;
import net.radol.model.Channel;

@Mapper(componentModel = "spring")
	public interface ChannelMapper extends EntityMapper<ChannelDTO, Channel> {
		

	}
