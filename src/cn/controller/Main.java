package cn.controller;

import cn.app.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class, WebFluxConfig.class);
        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(applicationContext).build();
        ReactorHttpHandlerAdapter httpHandlerAdapter=new ReactorHttpHandlerAdapter(handler);
        HttpServer.create().port(80).handle(httpHandlerAdapter).bind().block();
        System.in.read();
    }




}
