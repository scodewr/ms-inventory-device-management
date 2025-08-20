package br.com.scodewr.inventorydevicemanagment.application.services;

import br.com.scodewr.inventorydevicemanagment.domain.entities.AllocateDeviceEntity;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceEntity;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import br.com.scodewr.inventorydevicemanagment.domain.enums.CharacteristicAttributes;
import br.com.scodewr.inventorydevicemanagment.domain.enums.DeviceType;
import org.springframework.stereotype.Component;

@Component
public class EntityExtractor {

    public DeviceEntity getEntityByProperties(DeviceInventoryEntity entity) {
        String type = entity.getCharacteristics().get(0).get(CharacteristicAttributes.TYPE);

        return new AllocateDeviceEntity(DeviceType.valueOf(type));
    }
}
