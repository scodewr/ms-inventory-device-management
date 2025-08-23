package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out;

import br.com.scodewr.inventorydevicemanagment.infrastructure.mappers.EntitiesMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractAdapterOut<E, J, R extends JpaRepository<J, Integer>> {
    protected R repository;
    protected EntitiesMapper<E, J> entitiesMapper;

    protected AbstractAdapterOut(R repository, EntitiesMapper<E, J> mapper){
        this.repository = repository;
        this.entitiesMapper = mapper;
    }
}
