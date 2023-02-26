package co.com.appbank.api;

import co.com.appbank.model.command.ClienteCreadoCommand;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.usecase.ClienteCreadoUseCase;
import co.com.appbank.usecase.ClienteCreadoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(ClienteCreadoUseCase useCase) {
        return route(POST("/api/usecase/cliente"), request -> {
           return useCase.apply(request.bodyToMono(ClienteCreadoCommand.class)).collectList().
                   flatMap(event -> ServerResponse.ok().bodyValue(event));
//              return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).
//                      body(BodyInserters.fromPublisher(useCase.apply(request.bodyToMono(ClienteCreadoCommand.class)),
//                      DomainEvent.class));
           });


    }
}
