package org.kareem.springcloud.apigetwayservice.filters;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
@Component
public class MyFilter implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    @Override
    public ServerResponse filter(ServerRequest request, HandlerFunction<ServerResponse> next) throws Exception {
        return null;
    }

    @Override
    public HandlerFilterFunction<ServerResponse, ServerResponse> andThen(HandlerFilterFunction<ServerResponse, ServerResponse> after) {
        return HandlerFilterFunction.super.andThen(after);
    }

    @Override
    public HandlerFunction<ServerResponse> apply(HandlerFunction<ServerResponse> handler) {
        return HandlerFilterFunction.super.apply(handler);
    }
}
