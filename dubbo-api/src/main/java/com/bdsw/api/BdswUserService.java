package com.bdsw.api;

import com.bdsw.base.model.UserInfo;
import reactor.core.publisher.Mono;

public interface BdswUserService {

    Mono<UserInfo> verifyToken(String token);
}
