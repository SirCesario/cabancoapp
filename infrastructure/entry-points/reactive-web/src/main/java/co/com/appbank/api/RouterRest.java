package co.com.appbank.api;



import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.usecase.AgregarCuentaClienteUseCase;
import co.com.appbank.usecase.ClienteCreadoUseCase;
import co.com.appbank.usecase.command.AgregarCuentaClienteCommand;
import co.com.appbank.usecase.command.ClienteCreadoCommand;
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
    public RouterFunction<ServerResponse> clienteCreado(ClienteCreadoUseCase useCase) {
        return route(POST("/api/usecase/clientecreado").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.bodyToMono(ClienteCreadoCommand.class)),
                                DomainEvent.class)));
    }


    @Bean
    public RouterFunction<ServerResponse> agregarCuenta(AgregarCuentaClienteUseCase useCase){

        return  route(POST("/api/usecase/agregarcuenta").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.bodyToMono(AgregarCuentaClienteCommand.class)),
                                DomainEvent.class)));
    }
}

