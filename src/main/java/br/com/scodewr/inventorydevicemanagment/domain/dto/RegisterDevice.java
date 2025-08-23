package br.com.scodewr.inventorydevicemanagment.domain.dto;
import br.com.scodewr.inventorydevicemanagment.domain.enums.DeviceType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDevice extends AbstractDevice {

    private final DeviceType type;
    private Integer deviceCategoryId;
    private String deviceCategoryName;
    private Integer deviceModelId;

    private String deviceModelName;

    public RegisterDevice(DeviceType type) {
        this.type = type;
    }
}
