package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out;

import br.com.scodewr.inventorydevicemanagment.application.ports.out.DevicePortOut;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceEntity;
import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceJpaEntity;
import br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.repositories.DeviceRepository;
import br.com.scodewr.inventorydevicemanagment.infrastructure.mappers.EntitiesMapper;
import org.springframework.stereotype.Component;

@Component
public class DeviceAdapterOut extends AbstractAdapterOut<DeviceEntity, DeviceJpaEntity, DeviceRepository> implements DevicePortOut {

    protected DeviceAdapterOut(DeviceRepository repository, EntitiesMapper<DeviceEntity, DeviceJpaEntity> mapper) {
        super(repository, mapper);
    }

    @Override
    public DeviceEntity findById(DeviceEntity entityOfRepository, Integer id) {
        var jpa = repository.findById(id).orElse(null);
        return entitiesMapper.toEntity(jpa);
    }

    @Override
    public DeviceEntity save(DeviceEntity entityOfRepository) {
        var jpa = entitiesMapper.toJpa(entityOfRepository);
        jpa = repository.save(jpa);
        return entitiesMapper.toEntity(jpa);
    }

    @Override
    public DeviceEntity update(DeviceEntity entityOfRepository) {
        return save(entityOfRepository);
    }

    @Override
    public void delete(DeviceEntity entityOfRepository) {
        var jpa = entitiesMapper.toJpa(entityOfRepository);
        repository.delete(jpa);
    }
}
