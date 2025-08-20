package br.com.scodewr.inventorydevicemanagment.domain.entities;

import br.com.scodewr.inventorydevicemanagment.application.usecases.allocate.AllocateDeviceHGUHandler;
import br.com.scodewr.inventorydevicemanagment.domain.enums.DeviceType;

public class AllocateDeviceHGUEntity extends AllocateDeviceEntity {

    public AllocateDeviceHGUEntity(){
        super(DeviceType.HGU);
        super.handler = new AllocateDeviceHGUHandler();
    }
}
