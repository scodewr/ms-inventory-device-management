package br.com.scodewr.inventorydevicemanagment.application.ports.in;

public interface UseCaseHandler<T, E> {
    void setNext(UseCaseHandler<?, ?> nextHandler);
    E handle(T entity);
}
