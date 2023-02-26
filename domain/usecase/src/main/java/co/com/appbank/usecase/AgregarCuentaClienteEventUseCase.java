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

public class AgregarCuentaClienteEventUseCase extends UseCaseForCommand<AgregarCuentaClienteCommand> {

//    private final DomainEventRepository repository;
//
//    private  final EventBus bus;
//
//    AgregarCuentaClienteEventUseCase(DomainEventRepository repository, EventBus bus){
//        this.repository = repository;
//        this.bus = bus;
//    }

    @Override
    public Flux<DomainEvent> apply(Mono<AgregarCuentaClienteCommand> agregarCuentaClienteCommandMono){
        return null;
    }
//        return agregarCuentaClienteCommandMono.flatMapMany(command -> repository.findById(command.getClienteId())).
//                collectList().flatMapIterable(events -> {
//                    Cliente cliente = new Cliente(ClienteId.of("16"),new Nombre("Sofia"),new Apellido("Cuevas"),new Correo("Elizabeth15@gmail.com"),
//                            new Telefono("7824040"));
//                    return cliente.getUncommittedChanges();
//                }).map(event ->{
//                    bus.publish(event);
//                    return event;
//                }).flatMap(event -> repository.saveEvent(event));
//    }
}
