package br.com.scodewr.inventorydevicemanagment.infrastructure.mappers;

import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceCategoryEntity;
import br.com.scodewr.inventorydevicemanagment.domain.exceptions.IDMException;
import br.com.scodewr.inventorydevicemanagment.domain.messages.IDMStatusMessages;
import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceCategoryJpaEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DeviceCategoryEntityMapper implements EntitiesMapper<DeviceCategoryEntity, DeviceCategoryJpaEntity> {

    @Override
    public DeviceCategoryEntity toEntity(DeviceCategoryJpaEntity jpa) {
        if(null == jpa){
            log.warn(IDMStatusMessages.IDM_500.getCode(), IDMStatusMessages.IDM_500.getMessage(), "Objeto recebido para conversão está nulo.");
            return null;
        }
        return DeviceCategoryEntity.builder()
                .deviceCategoryId(jpa.getDeviceCategoryId())
                .deviceCategoryName(jpa.getName())
                .build();
    }

    @Override
    public DeviceCategoryJpaEntity toJpa(DeviceCategoryEntity entity) {
        if(null == entity){
            throw new IDMException(IDMStatusMessages.IDM_500.getCode(), IDMStatusMessages.IDM_500.getMessage(), "Objeto recebido para conversão está nulo.");
        }
        return DeviceCategoryJpaEntity.builder()
                .name(entity.deviceCategoryName())
                .build();
    }
}
