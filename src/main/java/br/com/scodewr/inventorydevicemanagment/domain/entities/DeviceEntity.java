package br.com.scodewr.inventorydevicemanagment.domain.entities;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import lombok.Getter;

@Getter
public abstract class DeviceEntity {
    protected UseCaseHandler<?> handler;
}
