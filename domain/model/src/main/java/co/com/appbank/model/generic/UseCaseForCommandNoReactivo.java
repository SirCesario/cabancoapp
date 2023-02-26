package co.com.appbank.model.generic;

import java.util.List;
import java.util.function.Function;

public abstract class UseCaseForCommandNoReactivo <R extends Command> implements Function<R, List<DomainEvent>> {
    public abstract List<DomainEvent> apply(R command);
}
