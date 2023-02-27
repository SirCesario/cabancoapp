package co.com.appbank.usecase.gateways;



import co.com.appbank.model.Cliente;
import co.com.appbank.model.generic.DomainEvent;
import reactor.core.publisher.Flux;

import java.util.List;


public interface RepositoryExample {

    DomainEvent saveEventNoReactivo(DomainEvent event);
    List<DomainEvent> findByIdNoReactivo(String agregateRootId);

    void deleteById(String id);

    Flux<Cliente> findAll();

}
