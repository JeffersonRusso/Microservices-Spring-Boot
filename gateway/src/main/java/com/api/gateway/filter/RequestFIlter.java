package com.api.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.image.DataBuffer;
import java.util.Map;
import java.util.Set;

@Component
public class RequestFIlter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        HttpHeaders headers = exchange.getRequest().getHeaders();
        Set<String> headerNames = headers.keySet();

        headerNames.forEach((header) -> {
            System.out.println(header + " " + headers.get(header));
        });

       return chain.filter(exchange);
    }
}
