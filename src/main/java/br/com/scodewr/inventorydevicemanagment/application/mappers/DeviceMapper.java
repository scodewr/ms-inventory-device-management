package br.com.scodewr.inventorydevicemanagment.application.mappers;

public interface DeviceMapper<D, E, R> {
    E fromDTO(D dto);
    R toResponseEntity(E entity);
}
