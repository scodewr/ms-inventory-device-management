package br.com.scodewr.inventorydevicemanagment.application.mappers;

import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDeviceHGU;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceEntity;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;

import java.time.Instant;
import java.util.Date;

public class RegisterDeviceHGUMapper implements DeviceMapper<RegisterDeviceHGU, DeviceEntity, DeviceInventoryEntity> {

    @Override
    public DeviceEntity fromDTO(RegisterDeviceHGU dto) {
        return DeviceEntity.builder()
                .created(Date.from(Instant.now()))
                .deviceCategoryId(dto.getDeviceCategoryId())
                .deviceModelId(dto.getDeviceModelId())
                .build();
    }

    @Override
    public DeviceInventoryEntity toResponseEntity(DeviceEntity entity) {
        return null;
    }
}
