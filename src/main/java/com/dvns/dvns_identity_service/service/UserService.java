package com.dvns.dvns_identity_service.service;

import com.dvns.dvns_identity_service.dto.request.UserCreationRequest;
import com.dvns.dvns_identity_service.dto.request.UserUpdateRequest;
import com.dvns.dvns_identity_service.dto.response.UserResponse;
import com.dvns.dvns_identity_service.entity.User;
import com.dvns.dvns_identity_service.enums.Role;
import com.dvns.dvns_identity_service.exception.AppException;
import com.dvns.dvns_identity_service.exception.ErrorCode;
import com.dvns.dvns_identity_service.mapper.UserMapper;
import com.dvns.dvns_identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.antlr.v4.runtime.ListTokenSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UserService
 * <p>
 * Version 1.0
 * <p>
 * Date:  1/14/2025
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 1/14/2025    NhanDinhVan    Create
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);

        Set<String> roles = new HashSet<>(List.of(Role.USER.name()));

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(String userId){
        return userMapper.toUserResponse(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        userMapper.updateUser(user, request);

//        user.setPassword(request.getPassword());
//        user.setLastname(request.getLastname());
//        user.setFirstname(request.getFirstname());
//        user.setDob(request.getDob());

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
