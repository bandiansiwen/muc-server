package com.bdsw.muc.user.service.impl;

import com.bdsw.muc.base.model.UserInfo;
import com.bdsw.muc.user.service.BdswUserTokenService;
import org.springframework.stereotype.Service;

@Service
public class BdswUserTokenServiceImpl implements BdswUserTokenService {

    @Override
    public UserInfo verifyToken(String token) {
        // 这里是真正的业务逻辑实现
        return new UserInfo().setUserId("lisi").setUserName("李四");
    }
}
