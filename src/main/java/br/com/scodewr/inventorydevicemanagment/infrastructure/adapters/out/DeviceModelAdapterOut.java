package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out;

import br.com.scodewr.inventorydevicemanagment.application.ports.out.DeviceModelPortOut;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceModelEntity;
import br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.repositories.DeviceModelRepository;
import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceModelJpaEntity;
import br.com.scodewr.inventorydevicemanagment.infrastructure.mappers.EntitiesMapper;
import org.springframework.stereotype.Component;

@Component
public class DeviceModelAdapterOut extends AbstractAdapterOut<DeviceModelEntity, DeviceModelJpaEntity, DeviceModelRepository>
    implements DeviceModelPortOut {

    protected DeviceModelAdapterOut(DeviceModelRepository repository, EntitiesMapper<DeviceModelEntity, DeviceModelJpaEntity> mapper) {
        super(repository, mapper);
    }

    @Override
    public DeviceModelEntity findByName(String name) {
        var jpa = repository.findByName(name).orElse(null);
        return entitiesMapper.toEntity(jpa);
    }
}
