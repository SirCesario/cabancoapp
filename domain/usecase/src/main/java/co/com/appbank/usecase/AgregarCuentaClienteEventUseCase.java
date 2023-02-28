package co.com.appbank.usecase;


import co.com.appbank.model.Cliente;
import co.com.appbank.model.events.ClienteCreado;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.model.values.ClienteId;
import co.com.appbank.model.values.CuentaId;
import co.com.appbank.model.values.FechaCreacionCuenta;
import co.com.appbank.usecase.command.AgregarCuentaClienteCommand;
import co.com.appbank.usecase.gateways.DomainEventRepository;
import co.com.appbank.usecase.gateways.EventBus;
import co.com.appbank.usecase.generic.USeCaseForCommand;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;
import java.util.function.Function;


public class AgregarCuentaClienteEventUseCase implements Function<Mono<ClienteCreado>, Flux<DomainEvent>> {
    public Flux<DomainEvent> apply(Mono<ClienteCreado> clienteCreadoMono){
        return null;
    }
//    private  DomainEventRepository repository;
//
//    private   EventBus bus;
//
//    public AgregarCuentaClienteEventUseCase(DomainEventRepository repository, EventBus bus){
//        this.repository = repository;
//        this.bus = bus;
//    }
//
//    @Override
//    public Flux<DomainEvent> apply(Mono<ClienteCreado> clienteCreadoMono){
//        return clienteCreadoMono.flatMapIterable(event ->{
//        Cliente cliente = Cliente.from(ClienteId.of(event.aggregateRootId()), List.of(event));
//        cliente.agregarCuenta(CuentaId.of(event.getCuentaId()),
//                new ClienteId(event.aggregateRootId()),new FechaCreacionCuenta(event));
//    })


}

