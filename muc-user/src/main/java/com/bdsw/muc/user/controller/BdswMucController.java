package com.bdsw.muc.user.controller;

import com.bdsw.muc.base.model.BdswRes;
import com.bdsw.muc.base.model.TokenInfo;
import com.bdsw.muc.base.model.TokenValidationResult;
import com.bdsw.muc.user.service.BdswUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class BdswMucController {

    @Autowired
    private BdswUserTokenService userTokenService;

    @RequestMapping("/validateToken")
    public Mono<BdswRes<TokenInfo>> validateToken(ServerHttpRequest request){

        // 从请求头中获取Authorization字段（可能为null）
        String authHeader = request.getHeaders().getFirst("Authorization");

        // 处理Authorization不存在的情况
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // 返回错误信息的Flux（或通过Mono.error抛异常）
            return Mono.just(new BdswRes<TokenInfo>().setCode(401).setMessage("Missing or invalid Authorization header"));
        }
        String token = authHeader.substring(7); // 去掉"Bearer "前缀

        TokenValidationResult validationResult = userTokenService.validateToken(token);
        return Mono.just(new BdswRes<TokenInfo>().setCode(0).setData(validationResult.getTokenInfo()).setMessage("success"));
    }

    @RequestMapping("/test")
    public Mono<String> test(){
        return Mono.just("user test");
    }

}
