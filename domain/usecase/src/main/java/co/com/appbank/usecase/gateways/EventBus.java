package co.com.appbank.usecase.gateways;


import co.com.appbank.model.generic.DomainEvent;

public interface EventBus {
    void publish(DomainEvent event);

    void publishError(Throwable errorEvent);
}
