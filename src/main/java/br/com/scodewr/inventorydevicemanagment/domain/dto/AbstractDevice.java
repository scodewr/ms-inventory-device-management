package br.com.scodewr.inventorydevicemanagment.domain.dto;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import lombok.Getter;

@Getter
public abstract class AbstractDevice {
    protected UseCaseHandler<?, ?> handler;
}
