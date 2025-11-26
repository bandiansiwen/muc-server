package com.bdsw.muc.user.service.impl;

import com.bdsw.muc.base.model.TokenInfo;
import com.bdsw.muc.base.model.TokenValidationResult;
import com.bdsw.muc.user.service.BdswUserTokenService;
import org.springframework.stereotype.Service;

@Service
public class BdswUserTokenServiceImpl implements BdswUserTokenService {

    @Override
    public TokenValidationResult validateToken(String token) {
        // 这里是真正的业务逻辑实现

        TokenInfo tokenInfo = new TokenInfo()
                .setUserId("zhangsan")
                .setUserName("张三");

        return TokenValidationResult.builder()
                .valid(true)
                .tokenInfo(tokenInfo)
                .build();
    }
}
