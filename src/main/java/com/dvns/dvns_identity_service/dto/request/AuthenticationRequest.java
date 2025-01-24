package com.dvns.dvns_identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * AuthenticationRequest
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
    String username;
    String password;
}
