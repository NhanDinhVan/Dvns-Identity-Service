package com.dvns.dvns_identity_service.configuration;

import com.dvns.dvns_identity_service.entity.User;
import com.dvns.dvns_identity_service.enums.Role;
import com.dvns.dvns_identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ApplicationInitConfig
 * <p>
 * Version 1.0
 * <p>
 * Date:  2/11/2025
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 2/11/2025    NhanDinhVan    Create
 */

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
          if(userRepository.getUserByUsername("admin").isEmpty()){
              Set<String> roles = new HashSet<>(List.of(Role.ADMIN.name()));

              User user = User.builder()
                      .username("admin")
                      .roles(roles)
                      .password(passwordEncoder.encode("admin"))
                      .build();
              userRepository.save(user);
              log.warn("Admin user has been created with default password: admin, please change it !");
          }
        };
    }
}
