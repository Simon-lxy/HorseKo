package com.horseko.gateway.exception;

import cn.dev33.satoken.exception.SaTokenException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horseko.gateway.entity.Result;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 网关全局异常处理
 *
 * @author Wayne
 * @data 2024/03/24 17:05:31
 **/

@Component
public class GateWayExceptionHandler implements ErrorWebExceptionHandler {


    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        ServerHttpResponse response = serverWebExchange.getResponse();
        Integer code = 200;
        String message = "";
        if (throwable instanceof SaTokenException) {
            code = 401;
            message = "用户无权限";
        } else {
            code = 500;
            message = "系统繁忙";
        }
        Result result = Result.fail(code, message);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory dataBufferFactory = response.bufferFactory();
            byte[] bytes = null;
            try {
                bytes = objectMapper.writeValueAsBytes(dataBufferFactory);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return dataBufferFactory.wrap(bytes);
        }));
    }
}
