package br.com.scodewr.inventorydevicemanagment.application.handlers;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.ports.out.EquipmentGateway;
import br.com.scodewr.inventorydevicemanagment.domain.entities.AccessAssociatedDevice;
import org.springframework.stereotype.Service;

@Service
public class AccessAssociatedDeviceHandler implements UseCaseHandler<AccessAssociatedDevice> {

    private EquipmentGateway equipmentGateway;


    @Override
    public void setNext(UseCaseHandler<?> nextHandler) {

    }

    @Override
    public void handle(AccessAssociatedDevice entity) {
        equipmentGateway.save(entity);
    }
}
