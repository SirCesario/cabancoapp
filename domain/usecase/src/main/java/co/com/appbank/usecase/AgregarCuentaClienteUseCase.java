package co.com.appbank.usecase;


import co.com.appbank.model.Cliente;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.usecase.command.AgregarCuentaClienteCommand;
import co.com.appbank.usecase.gateways.EventBus;
import co.com.appbank.model.values.*;
import co.com.appbank.usecase.generic.USeCaseForCommand;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AgregarCuentaClienteUseCase extends USeCaseForCommand<AgregarCuentaClienteCommand> {

//    private final DomainEventRepository repository;

    private EventBus bus;


//    AgregarCuentaClienteUseCase(DomainEventRepository repository, EventBus bus){
//        this.repository = repository;
//        this.bus = bus;
//    }


    @Override
    public Flux<DomainEvent> apply(Mono<AgregarCuentaClienteCommand> agregarCuentaClienteCommandMono){

        return agregarCuentaClienteCommandMono.flatMapIterable(command -> {
            Cliente cliente = new Cliente(ClienteId.of("7"),
                    new Nombre("Laura"),
                    new Apellido("Rodriguez"),
                    new Correo("soporte12@gmail.com"),
                    new Telefono("8010203"));
            return cliente.getUncommittedChanges();

        });
//        flatMap(repository::saveEvent);

    }
}
