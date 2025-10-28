package com.bdsw.role.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/role")
public class BdswRoleController {

    @RequestMapping("/test")
    public Mono<String> test(){
        return Mono.just("role test");
    }
}
