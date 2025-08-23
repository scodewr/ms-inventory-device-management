package br.com.scodewr.inventorydevicemanagment.application.usecases;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.services.HandlerRegistry;
import br.com.scodewr.inventorydevicemanagment.application.services.ValidationRules;
import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDevice;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RegisterDeviceUseCaseHandler implements UseCaseHandler<RegisterDevice, DeviceInventoryEntity> {

    private final ValidationRules validationRules = new ValidationRules();
    private final HandlerRegistry registry;

    public RegisterDeviceUseCaseHandler(HandlerRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void setNext(UseCaseHandler<?, ?> nextHandler) {
        // não utilizado neste estágio da cadeia
    }

    @Override
    public DeviceInventoryEntity handle(RegisterDevice dto) {
        RegisterDevice registerDeviceEntity = validationRules.validateAllocateDeviceEntity(dto);
        var handler = registry.get(registerDeviceEntity.getType());
        log.info("Roteando para handler específico do tipo: {}", registerDeviceEntity.getType());
        return handler.handle(registerDeviceEntity);
    }

}
