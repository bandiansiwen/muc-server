package com.bdsw.user.controller;

import com.bdsw.api.BdswUserService;
import com.bdsw.base.model.BdswRes;
import com.bdsw.base.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class BdswMucController {

    @Autowired
    private BdswUserService bdswUserService;

    @RequestMapping("/VerifyToken")
    public Mono<BdswRes<UserInfo>> VerifyToken(ServerHttpRequest request){

        // 从请求头中获取Authorization字段（可能为null）
        String authHeader = request.getHeaders().getFirst("Authorization");

        // 处理Authorization不存在的情况
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // 返回错误信息的Flux（或通过Mono.error抛异常）
            return Mono.just(new BdswRes<UserInfo>().setCode(401).setMessage("Missing or invalid Authorization header"));
        }
        String token = authHeader.substring(7); // 去掉"Bearer "前缀

        Mono<UserInfo> userInfoMono = bdswUserService.verifyToken(token);

        return userInfoMono.map(userInfo -> new BdswRes<UserInfo>().setCode(0).setData(userInfo).setMessage("success"))
                .onErrorReturn(new BdswRes<UserInfo>().setCode(500).setMessage("Token verification failed"));
    }

    @RequestMapping("/test")
    public Mono<String> test(){
        return Mono.just("user test");
    }

}
