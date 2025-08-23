package br.com.scodewr.inventorydevicemanagment.application.usecases;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.services.EntityExtractor;
import br.com.scodewr.inventorydevicemanagment.domain.dto.AbstractDevice;
import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDevice;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefineUseCaseHandler implements UseCaseHandler<DeviceInventoryEntity, DeviceInventoryEntity> {

    private final EntityExtractor extractor = new EntityExtractor();
    private final RegisterDeviceUseCaseHandler registerDeviceUseCaseHandler;

    @Override
    public void setNext(UseCaseHandler<?, ?> nextHandler) {
        // não utilizado, pois este é o primeiro elo da cadeia
    }

    @Override
    public DeviceInventoryEntity handle(DeviceInventoryEntity entity) {
        AbstractDevice deviceEntity = extractor.getEntityByProperties(entity);
        return registerDeviceUseCaseHandler.handle((RegisterDevice) deviceEntity);
    }
}
