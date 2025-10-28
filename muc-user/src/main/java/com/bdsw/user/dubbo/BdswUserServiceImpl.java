package com.bdsw.user.dubbo;

import com.bdsw.api.BdswUserService;
import com.bdsw.base.model.UserInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@DubboService
public class BdswUserServiceImpl implements BdswUserService {

    @Override
    public Mono<UserInfo> verifyToken(String token) {
        UserInfo userInfo = new UserInfo().setUserId("zhangsan").setUserName("张三");
        return Mono.just(userInfo);
    }
}