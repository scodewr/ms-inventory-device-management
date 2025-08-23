package br.com.scodewr.inventorydevicemanagment.domain.dto;

import br.com.scodewr.inventorydevicemanagment.domain.enums.DeviceType;
import lombok.Getter;

@Getter
public class RegisterDeviceHGU extends RegisterDevice {

    private String categoryModel;
    private String deviceModel;

    public RegisterDeviceHGU(){
        super(DeviceType.HGU);
    }
}
