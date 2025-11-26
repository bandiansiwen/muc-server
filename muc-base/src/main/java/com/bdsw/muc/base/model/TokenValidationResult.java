package com.bdsw.muc.base.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenValidationResult {
private boolean valid;
private long expireTime;
private TokenInfo tokenInfo;
private String errorCode;
private String errorMessage;
}