package co.com.appbank.usecase;


import co.com.appbank.model.Cliente;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.usecase.gateways.EventBus;
import co.com.appbank.usecase.generic.USeCaseForCommand;
import co.com.appbank.model.values.*;
import co.com.appbank.usecase.command.ClienteCreadoCommand;
import co.com.appbank.usecase.gateways.DomainEventRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ClienteCreadoUseCase extends USeCaseForCommand<ClienteCreadoCommand> {

   private final DomainEventRepository repository;

   private final EventBus bus;

    public ClienteCreadoUseCase(DomainEventRepository repository, EventBus bus){
        this.repository = repository;
        this.bus = bus;
   }

    @Override
    public Flux<DomainEvent> apply(Mono<ClienteCreadoCommand> clienteCreadoCommandMono){
        return  clienteCreadoCommandMono.flatMapIterable(command -> {
            Cliente cliente = new Cliente(ClienteId.of(command.getClienteId()),new Nombre(command.getNombre()),
                    new Apellido(command.getApellido()),new Correo(command.getCorreo()),new Telefono(command.getTelefono()),
                    new CuentaId(command.getCuentaId()));
            return cliente.getUncommittedChanges();
        }).flatMap(event ->{
            return repository.saveEvent(event);
        }).map(event ->{
            bus.publish(event);
            return event;
        });
    }
}
