package com.techfira.mapper;


import com.techfira.dto.UserReqDTO;
import com.techfira.dto.UserResDTO;
import com.techfira.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResDTO toDTO(User user);
    User toEntity(UserReqDTO userReqDTO);
    List<UserResDTO> toDTOList(List<User> users);
}
