package net.radol.mapper;

import org.mapstruct.Mapper;

import net.radol.dto.UserDTO;
import net.radol.model.User;

@Mapper(componentModel = "spring")
	public interface UserMapper extends EntityMapper<UserDTO, User> {
		

	}