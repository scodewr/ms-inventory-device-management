package br.com.scodewr.inventorydevicemanagment.application.services;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDevice;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import br.com.scodewr.inventorydevicemanagment.domain.enums.DeviceType;

import java.util.Map;

public class HandlerRegistry {
    private final Map<DeviceType, UseCaseHandler<? extends RegisterDevice, DeviceInventoryEntity>> handlers;

    public HandlerRegistry(Map<DeviceType, UseCaseHandler<? extends RegisterDevice, DeviceInventoryEntity>> handlers) {
        this.handlers = handlers;
    }

    @SuppressWarnings("unchecked")
    public <T extends RegisterDevice> UseCaseHandler<T, DeviceInventoryEntity> get(DeviceType type) {
        return (UseCaseHandler<T, DeviceInventoryEntity>) handlers.get(type);
    }
}

