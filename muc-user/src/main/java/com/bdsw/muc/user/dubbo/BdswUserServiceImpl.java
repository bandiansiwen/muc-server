package com.bdsw.muc.user.dubbo;

import com.bdsw.common.BaseResponse;
import com.bdsw.muc.*;
import com.bdsw.muc.base.model.TokenValidationResult;
import com.bdsw.muc.user.service.BdswUserTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@DubboService
public class BdswUserServiceImpl implements MUCService {

    @Resource
    private BdswUserTokenService userTokenService;

    @Override
    public TokenValidateResponse validateToken(TokenValidateRequest request) {
        TokenValidationResult validationResult = userTokenService.validateToken(request.getToken());
        if (validationResult.isValid()) {
            return createValidResponse(validationResult);
        } else {
            return createInvalidResponse(validationResult);
        }
    }

    @Override
    public CompletableFuture<TokenValidateResponse> validateTokenAsync(TokenValidateRequest request) {
        return null;
    }

    @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<RefreshTokenResponse> refreshTokenAsync(RefreshTokenRequest request) {
        return null;
    }

    @Override
    public GetUserPermissionsResponse getUserPermissions(GetUserPermissionsRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<GetUserPermissionsResponse> getUserPermissionsAsync(GetUserPermissionsRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<LoginResponse> loginAsync(LoginRequest request) {
        return null;
    }

    @Override
    public BaseResponse logout(LogoutRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<BaseResponse> logoutAsync(LogoutRequest request) {
        return null;
    }

    private TokenValidateResponse createValidResponse(TokenValidationResult result) {
        // 构建用户信息map
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("userName", result.getTokenInfo().getUserName());
        userInfo.put("userId", result.getTokenInfo().getUserId());

        return TokenValidateResponse.newBuilder()
                .setBase(createBaseResponse(true, "200", "Token验证成功"))
                .setValid(true)
                .setUserId(result.getTokenInfo().getUserId())
                .setReason("验证通过")
                .setExpireTime(result.getExpireTime())
                .putAllUserInfo(userInfo)
                .build();
    }

    private TokenValidateResponse createInvalidResponse(TokenValidationResult result) {
        return TokenValidateResponse.newBuilder()
                .setBase(createBaseResponse(false, result.getErrorCode(), result.getErrorMessage()))
                .setValid(false)
                .setReason(result.getErrorMessage())
                .build();
    }

    private BaseResponse createBaseResponse(boolean success, String code, String message) {
        return BaseResponse.newBuilder()
                .setSuccess(success)
                .setCode(code)
                .setMessage(message)
                .setTimestamp(System.currentTimeMillis())
                .build();
    }
}