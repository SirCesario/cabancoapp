package co.com.appbank.usecase;


import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.usecase.command.AgregarCuentaClienteCommand;
import co.com.appbank.usecase.gateways.DomainEventRepository;
import co.com.appbank.usecase.gateways.EventBus;
import co.com.appbank.usecase.generic.USeCaseForCommand;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AgregarCuentaClienteEventUseCase extends USeCaseForCommand<AgregarCuentaClienteCommand> {

    private final DomainEventRepository repository;

//    private  final EventBus bus;

    AgregarCuentaClienteEventUseCase(DomainEventRepository repository){
        this.repository = repository;

    }

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
