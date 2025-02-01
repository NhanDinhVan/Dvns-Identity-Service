package com.dvns.dvns_identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * IntrospectResponse
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
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IntrospectResponse {
    Boolean valid;
}
