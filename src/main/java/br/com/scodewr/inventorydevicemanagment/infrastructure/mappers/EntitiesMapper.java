package br.com.scodewr.inventorydevicemanagment.infrastructure.mappers;

public interface EntitiesMapper<E, J> {
    E toEntity(J jpa);
    J toJpa(E entity);
}
