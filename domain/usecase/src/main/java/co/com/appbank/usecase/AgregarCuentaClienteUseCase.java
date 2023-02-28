package co.com.appbank.usecase;


import co.com.appbank.model.Cliente;
import co.com.appbank.model.generic.DomainEvent;
import co.com.appbank.usecase.command.AgregarCuentaClienteCommand;
import co.com.appbank.usecase.gateways.DomainEventRepository;
import co.com.appbank.usecase.gateways.EventBus;
import co.com.appbank.model.values.*;
import co.com.appbank.usecase.generic.USeCaseForCommand;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AgregarCuentaClienteUseCase extends USeCaseForCommand<AgregarCuentaClienteCommand> {

    private final DomainEventRepository repository;

    private EventBus bus;


    public AgregarCuentaClienteUseCase(DomainEventRepository repository, EventBus bus){
        this.repository = repository;
        this.bus = bus;
    }


    @Override
    public Flux<DomainEvent> apply(Mono<AgregarCuentaClienteCommand> agregarCuentaClienteCommandMono){

        return agregarCuentaClienteCommandMono.flatMapMany(command -> repository.findById(command.getClienteId()).
                collectList().flatMapIterable(events -> {
                    Cliente cliente = Cliente.from(ClienteId.of(command.getClienteId()), events);

                    cliente.agregarCuenta(CuentaId.of(command.getCuentaId()),
                            new ClienteId(command.getClienteId()),
                            new FechaCreacionCuenta(command.getFechaCreacionCuenta()),
                            new TipoCuenta(command.getTipoCuenta()),
                            new Saldo(command.getSaldo()));
                    return cliente.getUncommittedChanges();
                }).map(event ->{
                    bus.publish(event);
                    return event;
                }).flatMap(event ->{
                    return repository.saveEvent(event);
                })
            );

        }
    }
