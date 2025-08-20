package br.com.scodewr.inventorydevicemanagment.application.handlers;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.domain.entities.SubscriberServiceDevice;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceDeviceHandler implements UseCaseHandler<SubscriberServiceDevice> {

    @Override
    public void setNext(UseCaseHandler<?> nextHandler) {

    }

    @Override
    public void handle(SubscriberServiceDevice entity) {

    }
}
