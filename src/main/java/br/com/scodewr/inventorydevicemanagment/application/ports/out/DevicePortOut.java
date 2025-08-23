package br.com.scodewr.inventorydevicemanagment.application.ports.out;

import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceEntity;

public interface DevicePortOut {
    DeviceEntity findById(DeviceEntity entityOfRepository, Integer id);
    DeviceEntity save(DeviceEntity entityOfRepository);
    DeviceEntity update(DeviceEntity entityOfRepository);
    void delete(DeviceEntity entityOfRepository);
}
