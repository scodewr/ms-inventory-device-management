package br.com.scodewr.inventorydevicemanagment.application.services;

import br.com.scodewr.inventorydevicemanagment.domain.dto.AbstractDevice;
import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDevice;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import br.com.scodewr.inventorydevicemanagment.domain.enums.CharacteristicAttributes;
import br.com.scodewr.inventorydevicemanagment.domain.enums.DeviceType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntityExtractor {

    public AbstractDevice getEntityByProperties(DeviceInventoryEntity entity) {
        String type = entity.characteristics().get(CharacteristicAttributes.TYPE);

        var registerDevice = new RegisterDevice(DeviceType.valueOf(type));

        registerDevice.setDeviceCategoryName(entity.characteristics().get(CharacteristicAttributes.CATEGORY));
        registerDevice.setDeviceModelName(entity.characteristics().get(CharacteristicAttributes.MODEL));

        return registerDevice;
    }
}
