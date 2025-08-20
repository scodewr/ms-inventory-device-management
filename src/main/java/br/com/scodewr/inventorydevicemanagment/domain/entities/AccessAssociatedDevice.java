package br.com.scodewr.inventorydevicemanagment.domain.entities;

import br.com.scodewr.inventorydevicemanagment.application.handlers.AccessAssociatedDeviceHandler;
import br.com.scodewr.inventorydevicemanagment.domain.enums.CharacteristicAttributes;
import lombok.Getter;

@Getter
public class AccessAssociatedDevice extends DeviceEntity {

    private String accessId;

    public AccessAssociatedDevice(DeviceInventoryEntity entity) {
        super.handler = new AccessAssociatedDeviceHandler();
        this.accessId = entity.getCharacteristics().get(0).get(CharacteristicAttributes.ID);
    }
}