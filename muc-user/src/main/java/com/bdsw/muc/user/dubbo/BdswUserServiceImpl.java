package com.bdsw.muc.user.dubbo;

import com.bdsw.common.BaseResponse;
import com.bdsw.muc.*;
import com.bdsw.muc.user.service.BdswUserTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Slf4j
@DubboService
public class BdswUserServiceImpl implements MUCService {

    @Resource
    private BdswUserTokenService userTokenService;

    @Override
    public Mono<TokenValidateResponse> validateToken(Mono<TokenValidateRequest> reactorRequest) {
        return null;
    }

    @Override
    public Mono<RefreshTokenResponse> refreshToken(Mono<RefreshTokenRequest> reactorRequest) {
        return null;
    }

    @Override
    public Mono<GetUserPermissionsResponse> getUserPermissions(Mono<GetUserPermissionsRequest> reactorRequest) {
        return null;
    }

    @Override
    public Mono<LoginResponse> login(Mono<LoginRequest> reactorRequest) {
        return null;
    }

    @Override
    public Mono<BaseResponse> logout(Mono<LogoutRequest> reactorRequest) {
        return null;
    }


//    @Override
//    public BdswUserServiceProto.UserInfo verifyToken(BdswUserServiceProto.TokenReq token) {
//        log.info("BdswUserServiceImpl.verifyToken: {}", token);
//        UserInfo userInfo = userTokenService.verifyToken(token.getToken());
//        // 实现验证逻辑
//        return BdswUserServiceProto.UserInfo.newBuilder()
//                .setUserId(userInfo.getUserId())
//                .setUserName(userInfo.getUserName())
//                .build();
//    }

}