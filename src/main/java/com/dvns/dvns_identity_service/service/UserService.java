package com.dvns.dvns_identity_service.service;

import com.dvns.dvns_identity_service.dto.request.UserCreationRequest;
import com.dvns.dvns_identity_service.dto.request.UserUpdateRequest;
import com.dvns.dvns_identity_service.entity.User;
import com.dvns.dvns_identity_service.exception.AppException;
import com.dvns.dvns_identity_service.exception.ErrorCode;
import com.dvns.dvns_identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String userId){
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public User updateUser(String userId, UserUpdateRequest request){
        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setLastname(request.getLastname());
        user.setFirstname(request.getFirstname());
        user.setDob(request.getDob());

        userRepository.save(user);

        return user;
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
