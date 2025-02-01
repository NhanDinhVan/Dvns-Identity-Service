package com.dvns.dvns_identity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * IntrospectToken
 * <p>
 * Version 1.0
 * <p>
 * Date:  2/1/2025
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 2/1/2025    NhanDinhVan    Create
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class IntrospectRequest {
    String token;
}
