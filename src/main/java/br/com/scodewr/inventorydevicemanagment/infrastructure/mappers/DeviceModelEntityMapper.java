package br.com.scodewr.inventorydevicemanagment.infrastructure.mappers;

import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceModelEntity;
import br.com.scodewr.inventorydevicemanagment.domain.exceptions.IDMException;
import br.com.scodewr.inventorydevicemanagment.domain.messages.IDMStatusMessages;
import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceModelJpaEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DeviceModelEntityMapper implements EntitiesMapper<DeviceModelEntity, DeviceModelJpaEntity> {

    @Override
    public DeviceModelEntity toEntity(DeviceModelJpaEntity jpa) {
        if(null == jpa){
            log.warn(IDMStatusMessages.IDM_500.getCode(), IDMStatusMessages.IDM_500.getMessage(), "Objeto recebido para conversão está nulo.");
            return null;
        }
        return DeviceModelEntity.builder()
                .deviceModelId(jpa.getDeviceModelId())
                .deviceModelName(jpa.getName())
                .build();
    }

    @Override
    public DeviceModelJpaEntity toJpa(DeviceModelEntity entity) {
        if(null == entity){
            throw new IDMException(IDMStatusMessages.IDM_500.getCode(), IDMStatusMessages.IDM_500.getMessage(), "Objeto recebido para conversão está nulo.");
        }
        return DeviceModelJpaEntity.builder()
                .name(entity.deviceModelName())
                .build();
    }
}
