package br.com.scodewr.inventorydevicemanagment.application.usecases;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.services.EntityExtractor;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceEntity;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefineUseCaseAllocateHandler implements UseCaseHandler<DeviceInventoryEntity> {

    private final EntityExtractor extractor;
    private UseCaseHandler<DeviceEntity> handler;

    @SuppressWarnings("unchecked")
    @Override
    public void setNext(UseCaseHandler<?> nextHandler) {
        this.handler = (UseCaseHandler<DeviceEntity>) nextHandler;
    }

    @Override
    public void handle(DeviceInventoryEntity entity) {
        DeviceEntity deviceEntity = extractor.getEntityByProperties(entity);
        setNext(deviceEntity.getHandler());
        handler.handle(deviceEntity);
    }
}
