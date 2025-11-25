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

import com.google.protobuf.Message;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.PathResolver;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.ServerService;
import org.apache.dubbo.rpc.TriRpcStatus;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import org.apache.dubbo.rpc.model.ServiceDescriptor;
import org.apache.dubbo.rpc.model.StubMethodDescriptor;
import org.apache.dubbo.rpc.model.StubServiceDescriptor;
import org.apache.dubbo.reactive.handler.ManyToManyMethodHandler;
import org.apache.dubbo.reactive.handler.ManyToOneMethodHandler;
import org.apache.dubbo.reactive.handler.OneToManyMethodHandler;
import org.apache.dubbo.reactive.calls.ReactorClientCalls;
import org.apache.dubbo.reactive.handler.OneToOneMethodHandler;

import org.apache.dubbo.rpc.stub.StubInvoker;
import org.apache.dubbo.rpc.stub.StubMethodHandler;
import org.apache.dubbo.rpc.stub.StubSuppliers;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public final class DubboMUCServiceTriple {

    private DubboMUCServiceTriple() {}

    public static final String SERVICE_NAME = MUCService.SERVICE_NAME;

    private static final StubServiceDescriptor serviceDescriptor = new StubServiceDescriptor(SERVICE_NAME,MUCService.class);

    static {
        org.apache.dubbo.rpc.protocol.tri.service.SchemaDescriptorRegistry.addSchemaDescriptor(SERVICE_NAME,MucProto.getDescriptor());
        StubSuppliers.addSupplier(SERVICE_NAME, DubboMUCServiceTriple::newStub);
        StubSuppliers.addSupplier(MUCService.JAVA_SERVICE_NAME,  DubboMUCServiceTriple::newStub);
        StubSuppliers.addDescriptor(SERVICE_NAME, serviceDescriptor);
        StubSuppliers.addDescriptor(MUCService.JAVA_SERVICE_NAME, serviceDescriptor);
    }

    @SuppressWarnings("all")
    public static MUCService newStub(Invoker<?> invoker) {
        return new MUCServiceStub((Invoker<MUCService>)invoker);
    }

    private static final StubMethodDescriptor validateTokenMethod = new StubMethodDescriptor("ValidateToken",
        com.bdsw.muc.TokenValidateRequest.class, com.bdsw.muc.TokenValidateResponse.class, MethodDescriptor.RpcType.UNARY,
        obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.TokenValidateRequest::parseFrom,
        com.bdsw.muc.TokenValidateResponse::parseFrom);
        /**
         * <pre>
         *  web, android, ios, windows, mac
         * </pre>
         */
    private static final StubMethodDescriptor refreshTokenMethod = new StubMethodDescriptor("RefreshToken",
        com.bdsw.muc.RefreshTokenRequest.class, com.bdsw.muc.RefreshTokenResponse.class, MethodDescriptor.RpcType.UNARY,
        obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.RefreshTokenRequest::parseFrom,
        com.bdsw.muc.RefreshTokenResponse::parseFrom);
    private static final StubMethodDescriptor getUserPermissionsMethod = new StubMethodDescriptor("GetUserPermissions",
        com.bdsw.muc.GetUserPermissionsRequest.class, com.bdsw.muc.GetUserPermissionsResponse.class, MethodDescriptor.RpcType.UNARY,
        obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.GetUserPermissionsRequest::parseFrom,
        com.bdsw.muc.GetUserPermissionsResponse::parseFrom);
    private static final StubMethodDescriptor loginMethod = new StubMethodDescriptor("Login",
        com.bdsw.muc.LoginRequest.class, com.bdsw.muc.LoginResponse.class, MethodDescriptor.RpcType.UNARY,
        obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.LoginRequest::parseFrom,
        com.bdsw.muc.LoginResponse::parseFrom);
    private static final StubMethodDescriptor logoutMethod = new StubMethodDescriptor("Logout",
        com.bdsw.muc.LogoutRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
        obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.LogoutRequest::parseFrom,
        com.bdsw.common.BaseResponse::parseFrom);




    static{
        serviceDescriptor.addMethod(validateTokenMethod);
        serviceDescriptor.addMethod(refreshTokenMethod);
        serviceDescriptor.addMethod(getUserPermissionsMethod);
        serviceDescriptor.addMethod(loginMethod);
        serviceDescriptor.addMethod(logoutMethod);
    }

    public static class MUCServiceStub implements MUCService{

        private final Invoker<MUCService> invoker;

        public MUCServiceStub(Invoker<MUCService> invoker) {
            this.invoker = invoker;
        }

        public Mono<com.bdsw.muc.TokenValidateResponse> validateToken(Mono<com.bdsw.muc.TokenValidateRequest> request) {
            return ReactorClientCalls.oneToOne(invoker, request, validateTokenMethod);
        }
            /**
         * <pre>
         *  web, android, ios, windows, mac
         * </pre>
         */
        public Mono<com.bdsw.muc.RefreshTokenResponse> refreshToken(Mono<com.bdsw.muc.RefreshTokenRequest> request) {
            return ReactorClientCalls.oneToOne(invoker, request, refreshTokenMethod);
        }
        public Mono<com.bdsw.muc.GetUserPermissionsResponse> getUserPermissions(Mono<com.bdsw.muc.GetUserPermissionsRequest> request) {
            return ReactorClientCalls.oneToOne(invoker, request, getUserPermissionsMethod);
        }
        public Mono<com.bdsw.muc.LoginResponse> login(Mono<com.bdsw.muc.LoginRequest> request) {
            return ReactorClientCalls.oneToOne(invoker, request, loginMethod);
        }
        public Mono<com.bdsw.common.BaseResponse> logout(Mono<com.bdsw.muc.LogoutRequest> request) {
            return ReactorClientCalls.oneToOne(invoker, request, logoutMethod);
        }
    }

    public static abstract class MUCServiceImplBase implements MUCService, ServerService<MUCService> {

        @Override
        public final Invoker<MUCService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

                pathResolver.addNativeStub( "/" + SERVICE_NAME + "/ValidateToken");
                // for compatibility
                pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/ValidateToken");
                pathResolver.addNativeStub( "/" + SERVICE_NAME + "/RefreshToken");
                // for compatibility
                pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/RefreshToken");
                pathResolver.addNativeStub( "/" + SERVICE_NAME + "/GetUserPermissions");
                // for compatibility
                pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/GetUserPermissions");
                pathResolver.addNativeStub( "/" + SERVICE_NAME + "/Login");
                // for compatibility
                pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/Login");
                pathResolver.addNativeStub( "/" + SERVICE_NAME + "/Logout");
                // for compatibility
                pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/Logout");

                handlers.put(validateTokenMethod.getMethodName(), new OneToOneMethodHandler<>(this::validateToken));
                handlers.put(refreshTokenMethod.getMethodName(), new OneToOneMethodHandler<>(this::refreshToken));
                handlers.put(getUserPermissionsMethod.getMethodName(), new OneToOneMethodHandler<>(this::getUserPermissions));
                handlers.put(loginMethod.getMethodName(), new OneToOneMethodHandler<>(this::login));
                handlers.put(logoutMethod.getMethodName(), new OneToOneMethodHandler<>(this::logout));

            return new StubInvoker<>(this, url, MUCService.class, handlers);
        }

        public Mono<com.bdsw.muc.TokenValidateResponse> validateToken(Mono<com.bdsw.muc.TokenValidateRequest> request) {
            throw unimplementedMethodException(validateTokenMethod);
        }
            /**
         * <pre>
         *  web, android, ios, windows, mac
         * </pre>
         */
        public Mono<com.bdsw.muc.RefreshTokenResponse> refreshToken(Mono<com.bdsw.muc.RefreshTokenRequest> request) {
            throw unimplementedMethodException(refreshTokenMethod);
        }
        public Mono<com.bdsw.muc.GetUserPermissionsResponse> getUserPermissions(Mono<com.bdsw.muc.GetUserPermissionsRequest> request) {
            throw unimplementedMethodException(getUserPermissionsMethod);
        }
        public Mono<com.bdsw.muc.LoginResponse> login(Mono<com.bdsw.muc.LoginRequest> request) {
            throw unimplementedMethodException(loginMethod);
        }
        public Mono<com.bdsw.common.BaseResponse> logout(Mono<com.bdsw.muc.LogoutRequest> request) {
            throw unimplementedMethodException(logoutMethod);
        }

        @Override
        public final ServiceDescriptor getServiceDescriptor() {
            return serviceDescriptor;
        }

        private RpcException unimplementedMethodException(StubMethodDescriptor methodDescriptor) {
            return TriRpcStatus.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented",
            "/" + serviceDescriptor.getInterfaceName() + "/" + methodDescriptor.getMethodName())).asException();
        }
    }
}
