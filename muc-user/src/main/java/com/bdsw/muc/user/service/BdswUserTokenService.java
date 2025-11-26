package com.bdsw.muc.user.service;

import com.bdsw.muc.base.model.TokenValidationResult;

public interface BdswUserTokenService {
    /**
     * 验证 token 的核心业务逻辑
     */
    TokenValidationResult validateToken(String token);
}
