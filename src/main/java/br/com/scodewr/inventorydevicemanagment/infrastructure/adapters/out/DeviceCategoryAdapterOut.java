package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out;

import br.com.scodewr.inventorydevicemanagment.application.ports.out.DeviceCategoryPortOut;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceCategoryEntity;
import br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.repositories.DeviceCategoryRepository;
import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceCategoryJpaEntity;
import br.com.scodewr.inventorydevicemanagment.infrastructure.mappers.EntitiesMapper;
import org.springframework.stereotype.Component;

@Component
public class DeviceCategoryAdapterOut extends AbstractAdapterOut<DeviceCategoryEntity, DeviceCategoryJpaEntity, DeviceCategoryRepository> implements DeviceCategoryPortOut {

    protected DeviceCategoryAdapterOut(DeviceCategoryRepository repository, EntitiesMapper<DeviceCategoryEntity, DeviceCategoryJpaEntity> mapper) {
        super(repository, mapper);
    }

    @Override
    public DeviceCategoryEntity findByName(String name) {
        var jpa = repository.findByName(name).orElse(null);
        return entitiesMapper.toEntity(jpa);
    }
}
