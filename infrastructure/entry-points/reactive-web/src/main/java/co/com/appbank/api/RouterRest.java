package co.com.appbank.api;


import co.com.appbank.api.userdto.ClienteCreadoDto;
import co.com.appbank.model.events.ClienteCreado;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.usecase.command.ClienteCreadoCommand;
import co.com.appbank.usecase.ClienteCreadoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(ClienteCreadoUseCase useCase) {
                return route(POST("/api/usecase/cliente"), request -> {
            return useCase
                    .apply(request.bodyToMono(ClienteCreadoCommand.class))
                    .collectList()
                    .flatMap(event-> {
                                ClienteCreadoDto eventoDTO = new ClienteCreadoDto((ClienteCreado) event.get(0));
                                return ServerResponse.ok().bodyValue(eventoDTO);
                            }
                    );
        });
    }
}

