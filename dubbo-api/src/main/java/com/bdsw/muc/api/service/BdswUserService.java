package com.bdsw.muc.api.service;

import com.bdsw.muc.api.model.BdswUserServiceProto;

public interface BdswUserService {

    BdswUserServiceProto.UserInfo verifyToken(BdswUserServiceProto.TokenReq req);
}
