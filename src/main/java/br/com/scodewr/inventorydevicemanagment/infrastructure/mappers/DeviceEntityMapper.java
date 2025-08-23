package br.com.scodewr.inventorydevicemanagment.infrastructure.mappers;

import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceEntity;
import br.com.scodewr.inventorydevicemanagment.domain.exceptions.IDMException;
import br.com.scodewr.inventorydevicemanagment.domain.messages.IDMStatusMessages;
import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceCategoryJpaEntity;
import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceJpaEntity;
import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceModelJpaEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DeviceEntityMapper implements EntitiesMapper<DeviceEntity, DeviceJpaEntity> {

    @Override
    public DeviceEntity toEntity(DeviceJpaEntity jpa) {
        if(null == jpa){
            log.warn(IDMStatusMessages.IDM_500.getCode(), IDMStatusMessages.IDM_500.getMessage(), "Objeto recebido para conversão está nulo.");
            return null;
        }
        return DeviceEntity.builder()
                .deviceId(jpa.getDeviceId())
                .deviceCategoryId(jpa.getCategory().getDeviceCategoryId())
                .deviceModelId(jpa.getDeviceModel().getDeviceModelId())
                .created(jpa.getCreated())
                .lastUpdate(jpa.getLastUpdate())
                .build();
    }

    @Override
    public DeviceJpaEntity toJpa(DeviceEntity entity) {
        if(null == entity){
            throw new IDMException(IDMStatusMessages.IDM_500.getCode(), IDMStatusMessages.IDM_500.getMessage(), "Objeto recebido para conversão está nulo.");
        }
        return DeviceJpaEntity.builder()
                .deviceId(entity.deviceId())
                .category(new DeviceCategoryJpaEntity(entity.deviceCategoryId()))
                .deviceModel(new DeviceModelJpaEntity(entity.deviceModelId()))
                .created(entity.created())
                .lastUpdate(entity.lastUpdate())
                .build();
    }
}
