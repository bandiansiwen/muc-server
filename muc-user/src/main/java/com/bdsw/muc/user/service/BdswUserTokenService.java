package com.bdsw.muc.user.service;

import com.bdsw.muc.base.model.UserInfo;

public interface BdswUserTokenService {
    /**
     * 验证 token 的核心业务逻辑
     */
    UserInfo verifyToken(String token);
}
