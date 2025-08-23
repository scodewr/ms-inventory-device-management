package br.com.scodewr.inventorydevicemanagment.application.ports.out;

import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceCategoryEntity;

public interface DeviceCategoryPortOut {
    DeviceCategoryEntity findByName(String name);
}
