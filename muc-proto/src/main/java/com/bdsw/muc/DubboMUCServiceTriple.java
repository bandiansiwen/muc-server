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
import org.apache.dubbo.rpc.stub.BiStreamMethodHandler;
import org.apache.dubbo.rpc.stub.ServerStreamMethodHandler;
import org.apache.dubbo.rpc.stub.StubInvocationUtil;
import org.apache.dubbo.rpc.stub.StubInvoker;
import org.apache.dubbo.rpc.stub.StubMethodHandler;
import org.apache.dubbo.rpc.stub.StubSuppliers;
import org.apache.dubbo.rpc.stub.UnaryStubMethodHandler;

import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public final class DubboMUCServiceTriple {

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

    private static final StubMethodDescriptor validateTokenAsyncMethod = new StubMethodDescriptor("ValidateToken",
    com.bdsw.muc.TokenValidateRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.TokenValidateRequest::parseFrom,
    com.bdsw.muc.TokenValidateResponse::parseFrom);

    private static final StubMethodDescriptor validateTokenProxyAsyncMethod = new StubMethodDescriptor("ValidateTokenAsync",
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

    private static final StubMethodDescriptor refreshTokenAsyncMethod = new StubMethodDescriptor("RefreshToken",
    com.bdsw.muc.RefreshTokenRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.RefreshTokenRequest::parseFrom,
    com.bdsw.muc.RefreshTokenResponse::parseFrom);

    private static final StubMethodDescriptor refreshTokenProxyAsyncMethod = new StubMethodDescriptor("RefreshTokenAsync",
    com.bdsw.muc.RefreshTokenRequest.class, com.bdsw.muc.RefreshTokenResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.RefreshTokenRequest::parseFrom,
    com.bdsw.muc.RefreshTokenResponse::parseFrom);
    private static final StubMethodDescriptor getUserPermissionsMethod = new StubMethodDescriptor("GetUserPermissions",
    com.bdsw.muc.GetUserPermissionsRequest.class, com.bdsw.muc.GetUserPermissionsResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.GetUserPermissionsRequest::parseFrom,
    com.bdsw.muc.GetUserPermissionsResponse::parseFrom);

    private static final StubMethodDescriptor getUserPermissionsAsyncMethod = new StubMethodDescriptor("GetUserPermissions",
    com.bdsw.muc.GetUserPermissionsRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.GetUserPermissionsRequest::parseFrom,
    com.bdsw.muc.GetUserPermissionsResponse::parseFrom);

    private static final StubMethodDescriptor getUserPermissionsProxyAsyncMethod = new StubMethodDescriptor("GetUserPermissionsAsync",
    com.bdsw.muc.GetUserPermissionsRequest.class, com.bdsw.muc.GetUserPermissionsResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.GetUserPermissionsRequest::parseFrom,
    com.bdsw.muc.GetUserPermissionsResponse::parseFrom);
    private static final StubMethodDescriptor loginMethod = new StubMethodDescriptor("Login",
    com.bdsw.muc.LoginRequest.class, com.bdsw.muc.LoginResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.LoginRequest::parseFrom,
    com.bdsw.muc.LoginResponse::parseFrom);

    private static final StubMethodDescriptor loginAsyncMethod = new StubMethodDescriptor("Login",
    com.bdsw.muc.LoginRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.LoginRequest::parseFrom,
    com.bdsw.muc.LoginResponse::parseFrom);

    private static final StubMethodDescriptor loginProxyAsyncMethod = new StubMethodDescriptor("LoginAsync",
    com.bdsw.muc.LoginRequest.class, com.bdsw.muc.LoginResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.LoginRequest::parseFrom,
    com.bdsw.muc.LoginResponse::parseFrom);
    private static final StubMethodDescriptor logoutMethod = new StubMethodDescriptor("Logout",
    com.bdsw.muc.LogoutRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.LogoutRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor logoutAsyncMethod = new StubMethodDescriptor("Logout",
    com.bdsw.muc.LogoutRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.LogoutRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);

    private static final StubMethodDescriptor logoutProxyAsyncMethod = new StubMethodDescriptor("LogoutAsync",
    com.bdsw.muc.LogoutRequest.class, com.bdsw.common.BaseResponse.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.LogoutRequest::parseFrom,
    com.bdsw.common.BaseResponse::parseFrom);




    static{
        serviceDescriptor.addMethod(validateTokenMethod);
        serviceDescriptor.addMethod(validateTokenProxyAsyncMethod);
        serviceDescriptor.addMethod(refreshTokenMethod);
        serviceDescriptor.addMethod(refreshTokenProxyAsyncMethod);
        serviceDescriptor.addMethod(getUserPermissionsMethod);
        serviceDescriptor.addMethod(getUserPermissionsProxyAsyncMethod);
        serviceDescriptor.addMethod(loginMethod);
        serviceDescriptor.addMethod(loginProxyAsyncMethod);
        serviceDescriptor.addMethod(logoutMethod);
        serviceDescriptor.addMethod(logoutProxyAsyncMethod);
    }

    public static class MUCServiceStub implements MUCService{
        private final Invoker<MUCService> invoker;

        public MUCServiceStub(Invoker<MUCService> invoker) {
            this.invoker = invoker;
        }

        @Override
        public com.bdsw.muc.TokenValidateResponse validateToken(com.bdsw.muc.TokenValidateRequest request){
            return StubInvocationUtil.unaryCall(invoker, validateTokenMethod, request);
        }

        public CompletableFuture<com.bdsw.muc.TokenValidateResponse> validateTokenAsync(com.bdsw.muc.TokenValidateRequest request){
            return StubInvocationUtil.unaryCall(invoker, validateTokenAsyncMethod, request);
        }

        public void validateToken(com.bdsw.muc.TokenValidateRequest request, StreamObserver<com.bdsw.muc.TokenValidateResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, validateTokenMethod , request, responseObserver);
        }
        /**
         * <pre>
         *  web, android, ios, windows, mac
         * </pre>
         */
        @Override
        public com.bdsw.muc.RefreshTokenResponse refreshToken(com.bdsw.muc.RefreshTokenRequest request){
            return StubInvocationUtil.unaryCall(invoker, refreshTokenMethod, request);
        }

        public CompletableFuture<com.bdsw.muc.RefreshTokenResponse> refreshTokenAsync(com.bdsw.muc.RefreshTokenRequest request){
            return StubInvocationUtil.unaryCall(invoker, refreshTokenAsyncMethod, request);
        }

        /**
         * <pre>
         *  web, android, ios, windows, mac
         * </pre>
         */
        public void refreshToken(com.bdsw.muc.RefreshTokenRequest request, StreamObserver<com.bdsw.muc.RefreshTokenResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, refreshTokenMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.muc.GetUserPermissionsResponse getUserPermissions(com.bdsw.muc.GetUserPermissionsRequest request){
            return StubInvocationUtil.unaryCall(invoker, getUserPermissionsMethod, request);
        }

        public CompletableFuture<com.bdsw.muc.GetUserPermissionsResponse> getUserPermissionsAsync(com.bdsw.muc.GetUserPermissionsRequest request){
            return StubInvocationUtil.unaryCall(invoker, getUserPermissionsAsyncMethod, request);
        }

        public void getUserPermissions(com.bdsw.muc.GetUserPermissionsRequest request, StreamObserver<com.bdsw.muc.GetUserPermissionsResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, getUserPermissionsMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.muc.LoginResponse login(com.bdsw.muc.LoginRequest request){
            return StubInvocationUtil.unaryCall(invoker, loginMethod, request);
        }

        public CompletableFuture<com.bdsw.muc.LoginResponse> loginAsync(com.bdsw.muc.LoginRequest request){
            return StubInvocationUtil.unaryCall(invoker, loginAsyncMethod, request);
        }

        public void login(com.bdsw.muc.LoginRequest request, StreamObserver<com.bdsw.muc.LoginResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, loginMethod , request, responseObserver);
        }
        @Override
        public com.bdsw.common.BaseResponse logout(com.bdsw.muc.LogoutRequest request){
            return StubInvocationUtil.unaryCall(invoker, logoutMethod, request);
        }

        public CompletableFuture<com.bdsw.common.BaseResponse> logoutAsync(com.bdsw.muc.LogoutRequest request){
            return StubInvocationUtil.unaryCall(invoker, logoutAsyncMethod, request);
        }

        public void logout(com.bdsw.muc.LogoutRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            StubInvocationUtil.unaryCall(invoker, logoutMethod , request, responseObserver);
        }



    }

    public static abstract class MUCServiceImplBase implements MUCService, ServerService<MUCService> {

        private <T, R> BiConsumer<T, StreamObserver<R>> syncToAsync(java.util.function.Function<T, R> syncFun) {
            return new BiConsumer<T, StreamObserver<R>>() {
                @Override
                public void accept(T t, StreamObserver<R> observer) {
                    try {
                        R ret = syncFun.apply(t);
                        observer.onNext(ret);
                        observer.onCompleted();
                    } catch (Throwable e) {
                        observer.onError(e);
                    }
                }
            };
        }

        @Override
        public CompletableFuture<com.bdsw.muc.TokenValidateResponse> validateTokenAsync(com.bdsw.muc.TokenValidateRequest request){
                return CompletableFuture.completedFuture(validateToken(request));
        }
        @Override
        public CompletableFuture<com.bdsw.muc.RefreshTokenResponse> refreshTokenAsync(com.bdsw.muc.RefreshTokenRequest request){
                return CompletableFuture.completedFuture(refreshToken(request));
        }
        @Override
        public CompletableFuture<com.bdsw.muc.GetUserPermissionsResponse> getUserPermissionsAsync(com.bdsw.muc.GetUserPermissionsRequest request){
                return CompletableFuture.completedFuture(getUserPermissions(request));
        }
        @Override
        public CompletableFuture<com.bdsw.muc.LoginResponse> loginAsync(com.bdsw.muc.LoginRequest request){
                return CompletableFuture.completedFuture(login(request));
        }
        @Override
        public CompletableFuture<com.bdsw.common.BaseResponse> logoutAsync(com.bdsw.muc.LogoutRequest request){
                return CompletableFuture.completedFuture(logout(request));
        }

        /**
        * This server stream type unary method is <b>only</b> used for generated stub to support async unary method.
        * It will not be called if you are NOT using Dubbo3 generated triple stub and <b>DO NOT</b> implement this method.
        */
        public void validateToken(com.bdsw.muc.TokenValidateRequest request, StreamObserver<com.bdsw.muc.TokenValidateResponse> responseObserver){
            validateTokenAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void refreshToken(com.bdsw.muc.RefreshTokenRequest request, StreamObserver<com.bdsw.muc.RefreshTokenResponse> responseObserver){
            refreshTokenAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void getUserPermissions(com.bdsw.muc.GetUserPermissionsRequest request, StreamObserver<com.bdsw.muc.GetUserPermissionsResponse> responseObserver){
            getUserPermissionsAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void login(com.bdsw.muc.LoginRequest request, StreamObserver<com.bdsw.muc.LoginResponse> responseObserver){
            loginAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }
        public void logout(com.bdsw.muc.LogoutRequest request, StreamObserver<com.bdsw.common.BaseResponse> responseObserver){
            logoutAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }

        @Override
        public final Invoker<MUCService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/ValidateToken");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/ValidateTokenAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/ValidateToken");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/ValidateTokenAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/RefreshToken");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/RefreshTokenAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/RefreshToken");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/RefreshTokenAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/GetUserPermissions");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/GetUserPermissionsAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/GetUserPermissions");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/GetUserPermissionsAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/Login");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/LoginAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/Login");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/LoginAsync");

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/Logout");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/LogoutAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/Logout");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/LogoutAsync");


            BiConsumer<com.bdsw.muc.TokenValidateRequest, StreamObserver<com.bdsw.muc.TokenValidateResponse>> validateTokenFunc = this::validateToken;
            handlers.put(validateTokenMethod.getMethodName(), new UnaryStubMethodHandler<>(validateTokenFunc));
            BiConsumer<com.bdsw.muc.TokenValidateRequest, StreamObserver<com.bdsw.muc.TokenValidateResponse>> validateTokenAsyncFunc = syncToAsync(this::validateToken);
            handlers.put(validateTokenProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(validateTokenAsyncFunc));
            BiConsumer<com.bdsw.muc.RefreshTokenRequest, StreamObserver<com.bdsw.muc.RefreshTokenResponse>> refreshTokenFunc = this::refreshToken;
            handlers.put(refreshTokenMethod.getMethodName(), new UnaryStubMethodHandler<>(refreshTokenFunc));
            BiConsumer<com.bdsw.muc.RefreshTokenRequest, StreamObserver<com.bdsw.muc.RefreshTokenResponse>> refreshTokenAsyncFunc = syncToAsync(this::refreshToken);
            handlers.put(refreshTokenProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(refreshTokenAsyncFunc));
            BiConsumer<com.bdsw.muc.GetUserPermissionsRequest, StreamObserver<com.bdsw.muc.GetUserPermissionsResponse>> getUserPermissionsFunc = this::getUserPermissions;
            handlers.put(getUserPermissionsMethod.getMethodName(), new UnaryStubMethodHandler<>(getUserPermissionsFunc));
            BiConsumer<com.bdsw.muc.GetUserPermissionsRequest, StreamObserver<com.bdsw.muc.GetUserPermissionsResponse>> getUserPermissionsAsyncFunc = syncToAsync(this::getUserPermissions);
            handlers.put(getUserPermissionsProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(getUserPermissionsAsyncFunc));
            BiConsumer<com.bdsw.muc.LoginRequest, StreamObserver<com.bdsw.muc.LoginResponse>> loginFunc = this::login;
            handlers.put(loginMethod.getMethodName(), new UnaryStubMethodHandler<>(loginFunc));
            BiConsumer<com.bdsw.muc.LoginRequest, StreamObserver<com.bdsw.muc.LoginResponse>> loginAsyncFunc = syncToAsync(this::login);
            handlers.put(loginProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(loginAsyncFunc));
            BiConsumer<com.bdsw.muc.LogoutRequest, StreamObserver<com.bdsw.common.BaseResponse>> logoutFunc = this::logout;
            handlers.put(logoutMethod.getMethodName(), new UnaryStubMethodHandler<>(logoutFunc));
            BiConsumer<com.bdsw.muc.LogoutRequest, StreamObserver<com.bdsw.common.BaseResponse>> logoutAsyncFunc = syncToAsync(this::logout);
            handlers.put(logoutProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(logoutAsyncFunc));




            return new StubInvoker<>(this, url, MUCService.class, handlers);
        }


        @Override
        public com.bdsw.muc.TokenValidateResponse validateToken(com.bdsw.muc.TokenValidateRequest request){
            throw unimplementedMethodException(validateTokenMethod);
        }

        @Override
        public com.bdsw.muc.RefreshTokenResponse refreshToken(com.bdsw.muc.RefreshTokenRequest request){
            throw unimplementedMethodException(refreshTokenMethod);
        }

        @Override
        public com.bdsw.muc.GetUserPermissionsResponse getUserPermissions(com.bdsw.muc.GetUserPermissionsRequest request){
            throw unimplementedMethodException(getUserPermissionsMethod);
        }

        @Override
        public com.bdsw.muc.LoginResponse login(com.bdsw.muc.LoginRequest request){
            throw unimplementedMethodException(loginMethod);
        }

        @Override
        public com.bdsw.common.BaseResponse logout(com.bdsw.muc.LogoutRequest request){
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
