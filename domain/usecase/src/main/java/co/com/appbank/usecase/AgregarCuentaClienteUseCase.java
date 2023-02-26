package co.com.appbank.usecase;


import co.com.appbank.model.Cliente;
import co.com.appbank.model.command.AgregarCuentaClienteCommand;
import co.com.appbank.model.gateways.DomainEventRepository;
import co.com.appbank.model.gateways.EventBus;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.model.generic.UseCaseForCommand;
import co.com.appbank.model.values.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AgregarCuentaClienteUseCase extends UseCaseForCommand<AgregarCuentaClienteCommand> {

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
