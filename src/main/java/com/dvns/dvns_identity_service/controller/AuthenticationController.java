package com.dvns.dvns_identity_service.controller;

import com.dvns.dvns_identity_service.dto.request.AuthenticationRequest;
import com.dvns.dvns_identity_service.dto.request.IntrospectRequest;
import com.dvns.dvns_identity_service.dto.response.ApiResponse;
import com.dvns.dvns_identity_service.dto.response.AuthenticationResponse;
import com.dvns.dvns_identity_service.dto.response.IntrospectResponse;
import com.dvns.dvns_identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * AuthenticationController
 * <p>
 * Version 1.0
 * <p>
 * Date:  1/24/2025
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 1/24/2025    NhanDinhVan    Create
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authenticationService.authenticate(request))
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspectToken(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        return ApiResponse.<IntrospectResponse>builder()
                .result(authenticationService.introspect(request))
                .build();
    }
}
