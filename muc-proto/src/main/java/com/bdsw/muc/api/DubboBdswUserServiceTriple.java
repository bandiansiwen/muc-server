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

package com.bdsw.muc.api;

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

public final class DubboBdswUserServiceTriple {

    private DubboBdswUserServiceTriple() {}

    public static final String SERVICE_NAME = BdswUserService.SERVICE_NAME;

    private static final StubServiceDescriptor serviceDescriptor = new StubServiceDescriptor(SERVICE_NAME,BdswUserService.class);

    static {
        org.apache.dubbo.rpc.protocol.tri.service.SchemaDescriptorRegistry.addSchemaDescriptor(SERVICE_NAME,BdswUserServiceProto.getDescriptor());
        StubSuppliers.addSupplier(SERVICE_NAME, DubboBdswUserServiceTriple::newStub);
        StubSuppliers.addSupplier(BdswUserService.JAVA_SERVICE_NAME,  DubboBdswUserServiceTriple::newStub);
        StubSuppliers.addDescriptor(SERVICE_NAME, serviceDescriptor);
        StubSuppliers.addDescriptor(BdswUserService.JAVA_SERVICE_NAME, serviceDescriptor);
    }

    @SuppressWarnings("all")
    public static BdswUserService newStub(Invoker<?> invoker) {
        return new BdswUserServiceStub((Invoker<BdswUserService>)invoker);
    }

        /**
         * <pre>
         *  一个简单的 RPC 方法
         * </pre>
         */
    private static final StubMethodDescriptor verifyTokenMethod = new StubMethodDescriptor("verifyToken",
        com.bdsw.muc.api.TokenReq.class, com.bdsw.muc.api.UserInfo.class, MethodDescriptor.RpcType.UNARY,
        obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.bdsw.muc.api.TokenReq::parseFrom,
        com.bdsw.muc.api.UserInfo::parseFrom);




    static{
        serviceDescriptor.addMethod(verifyTokenMethod);
    }

    public static class BdswUserServiceStub implements BdswUserService{

        private final Invoker<BdswUserService> invoker;

        public BdswUserServiceStub(Invoker<BdswUserService> invoker) {
            this.invoker = invoker;
        }

            /**
         * <pre>
         *  一个简单的 RPC 方法
         * </pre>
         */
        public Mono<com.bdsw.muc.api.UserInfo> verifyToken(Mono<com.bdsw.muc.api.TokenReq> request) {
            return ReactorClientCalls.oneToOne(invoker, request, verifyTokenMethod);
        }
    }

    public static abstract class BdswUserServiceImplBase implements BdswUserService, ServerService<BdswUserService> {

        @Override
        public final Invoker<BdswUserService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

                pathResolver.addNativeStub( "/" + SERVICE_NAME + "/verifyToken");
                // for compatibility
                pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/verifyToken");

                handlers.put(verifyTokenMethod.getMethodName(), new OneToOneMethodHandler<>(this::verifyToken));

            return new StubInvoker<>(this, url, BdswUserService.class, handlers);
        }

            /**
         * <pre>
         *  一个简单的 RPC 方法
         * </pre>
         */
        public Mono<com.bdsw.muc.api.UserInfo> verifyToken(Mono<com.bdsw.muc.api.TokenReq> request) {
            throw unimplementedMethodException(verifyTokenMethod);
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
