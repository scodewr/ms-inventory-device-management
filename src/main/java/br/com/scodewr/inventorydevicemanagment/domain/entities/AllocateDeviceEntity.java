package br.com.scodewr.inventorydevicemanagment.domain.entities;

import br.com.scodewr.inventorydevicemanagment.application.services.ValidationRules;
import br.com.scodewr.inventorydevicemanagment.application.usecases.AllocateDeviceUseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.domain.enums.DeviceType;
import lombok.Getter;

@Getter
public class AllocateDeviceEntity extends DeviceEntity {

    private final DeviceType type;

    public AllocateDeviceEntity(DeviceType type) {
        super.handler = new AllocateDeviceUseCaseHandler(new ValidationRules());
        this.type = type;
    }
}
