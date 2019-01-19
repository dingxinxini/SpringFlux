package cn.controller;

import cn.handler.PersonHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class WebFluxApplication {
    public static void main(String[] args) throws Exception{

        //接收/person/{id}"  json类型的数据 ，GET请求 ，交给personHandler下的list方法处理
        HttpServer.create().port(80).handle(new ReactorHttpHandlerAdapter
                (toHttpHandler(route(accept(APPLICATION_JSON_UTF8).and(GET("/person/{id}")),
                        PersonHandler::list)))).bind().block();
        System.in.read();
    }

}
