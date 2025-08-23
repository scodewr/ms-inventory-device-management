package br.com.scodewr.inventorydevicemanagment.application.usecases.allocate;

import br.com.scodewr.inventorydevicemanagment.application.handlers.AbstractHandler;
import br.com.scodewr.inventorydevicemanagment.application.mappers.DeviceMapper;
import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.ports.out.DeviceCategoryPortOut;
import br.com.scodewr.inventorydevicemanagment.application.ports.out.DevicePortOut;
import br.com.scodewr.inventorydevicemanagment.application.ports.out.DeviceModelPortOut;
import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDeviceHGU;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceEntity;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RegisterDeviceHGUHandler extends AbstractHandler<RegisterDeviceHGU, DeviceEntity, DeviceInventoryEntity>
        implements UseCaseHandler<RegisterDeviceHGU, DeviceInventoryEntity> {

    public RegisterDeviceHGUHandler(DevicePortOut devicePortOut,
                                    DeviceCategoryPortOut deviceCategoryPortOut,
                                    DeviceModelPortOut deviceModelPortOut,
                                    DeviceMapper<RegisterDeviceHGU, DeviceEntity, DeviceInventoryEntity> mapper) {
        this.devicePortOut = devicePortOut;
        this.deviceCategoryPortOut = deviceCategoryPortOut;
        this.deviceModelPortOut = deviceModelPortOut;
        this.mapper = mapper;
    }

    @Override
    public void setNext(UseCaseHandler<?, ?> nextHandler) {
        log.info("Final Step of Allocate HGU has executed successfully!");
    }

    @Override
    public DeviceInventoryEntity handle(RegisterDeviceHGU dto) {
        log.info("Starting Allocate HGU...");

        var category = deviceCategoryPortOut.findByName(dto.getDeviceCategoryName());
        var model = deviceModelPortOut.findByName(dto.getDeviceModelName());

        dto.setDeviceCategoryId(category.deviceCategoryId());
        dto.setDeviceModelId(model.deviceModelId());

        var entity = mapper.fromDTO(dto);
        entity = devicePortOut.save(entity);
        var responseEntity = mapper.toResponseEntity(entity);

        setNext(null);
        return responseEntity;
    }
}
