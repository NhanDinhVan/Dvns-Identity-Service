package com.dvns.dvns_identity_service.mapper;

import com.dvns.dvns_identity_service.dto.request.UserCreationRequest;
import com.dvns.dvns_identity_service.dto.request.UserUpdateRequest;
import com.dvns.dvns_identity_service.dto.response.UserResponse;
import com.dvns.dvns_identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * UserMapper
 * <p>
 * Version 1.0
 * <p>
 * Date:  1/22/2025
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 1/22/2025    NhanDinhVan    Create
 */

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

//    @Mapping(source = "firstname", target = "lastname")
//    @Mapping(target = "lastname", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
    UserResponse toUserResponse(User user);
}
