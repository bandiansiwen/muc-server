/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.bdsw.muc;

import org.apache.dubbo.common.stream.StreamObserver;
import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public interface MUCService extends org.apache.dubbo.rpc.model.DubboStub {

    String JAVA_SERVICE_NAME = "com.bdsw.muc.MUCService";
    String SERVICE_NAME = "com.bdsw.muc.MUCService";
    com.bdsw.muc.TokenValidateResponse validateToken(com.bdsw.muc.TokenValidateRequest request);

    CompletableFuture<com.bdsw.muc.TokenValidateResponse> validateTokenAsync(com.bdsw.muc.TokenValidateRequest request);



    /**
         * <pre>
         *  web, android, ios, windows, mac
         * </pre>
         */
    com.bdsw.muc.RefreshTokenResponse refreshToken(com.bdsw.muc.RefreshTokenRequest request);

    CompletableFuture<com.bdsw.muc.RefreshTokenResponse> refreshTokenAsync(com.bdsw.muc.RefreshTokenRequest request);



    com.bdsw.muc.GetUserPermissionsResponse getUserPermissions(com.bdsw.muc.GetUserPermissionsRequest request);

    CompletableFuture<com.bdsw.muc.GetUserPermissionsResponse> getUserPermissionsAsync(com.bdsw.muc.GetUserPermissionsRequest request);



    com.bdsw.muc.LoginResponse login(com.bdsw.muc.LoginRequest request);

    CompletableFuture<com.bdsw.muc.LoginResponse> loginAsync(com.bdsw.muc.LoginRequest request);



    com.bdsw.common.BaseResponse logout(com.bdsw.muc.LogoutRequest request);

    CompletableFuture<com.bdsw.common.BaseResponse> logoutAsync(com.bdsw.muc.LogoutRequest request);








}
