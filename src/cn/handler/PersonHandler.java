package cn.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class PersonHandler {
    public static Mono<ServerResponse> list( ServerRequest request){
     return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).build();
    }
}
