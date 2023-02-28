package co.com.appbank.usecase.generic;


import co.com.appbank.model.generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsecaseForCommandReactive <R extends DomainEvent>{
    Flux<DomainEvent> apply(Mono<R> rMono);
}
