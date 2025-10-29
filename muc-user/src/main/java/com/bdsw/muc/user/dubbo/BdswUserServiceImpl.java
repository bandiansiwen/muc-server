package com.bdsw.muc.user.dubbo;

import com.bdsw.muc.api.model.BdswUserServiceProto;
import com.bdsw.muc.api.service.BdswUserService;
import com.bdsw.muc.base.model.UserInfo;
import com.bdsw.muc.user.service.BdswUserTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@Slf4j
@DubboService
public class BdswUserServiceImpl implements BdswUserService {

    @Resource
    private BdswUserTokenService userTokenService;

    @Override
    public BdswUserServiceProto.UserInfo verifyToken(BdswUserServiceProto.TokenReq token) {
        log.info("BdswUserServiceImpl.verifyToken: {}", token);
        UserInfo userInfo = userTokenService.verifyToken(token.getToken());
        // 实现验证逻辑
        return BdswUserServiceProto.UserInfo.newBuilder()
                .setUserId(userInfo.getUserId())
                .setUserName(userInfo.getUserName())
                .build();
    }

}