package br.com.scodewr.inventorydevicemanagment.application.ports.in;

public interface UseCaseHandler<T> {
    void setNext(UseCaseHandler<?> nextHandler);
    void handle(T entity);
}
