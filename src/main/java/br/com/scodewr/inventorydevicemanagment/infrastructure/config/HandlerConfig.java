package br.com.scodewr.inventorydevicemanagment.infrastructure.config;

import br.com.scodewr.inventorydevicemanagment.application.mappers.RegisterDeviceHGUMapper;
import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.services.HandlerRegistry;
import br.com.scodewr.inventorydevicemanagment.application.usecases.DefineUseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.usecases.RegisterDeviceUseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.usecases.allocate.RegisterDeviceHGUHandler;
import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDevice;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import br.com.scodewr.inventorydevicemanagment.domain.enums.DeviceType;
import br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.DeviceAdapterOut;
import br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.DeviceCategoryAdapterOut;
import br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.DeviceModelAdapterOut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

@Configuration
public class HandlerConfig {

    @Bean
    public RegisterDeviceHGUHandler allocateDeviceHGUHandler(
            DeviceAdapterOut deviceAdapterOut,
            DeviceCategoryAdapterOut deviceCategoryAdapterOut,
            DeviceModelAdapterOut deviceModelAdapterOut
    ) {
        return new RegisterDeviceHGUHandler(deviceAdapterOut, deviceCategoryAdapterOut, deviceModelAdapterOut, new RegisterDeviceHGUMapper());
    }

    @Bean
    public HandlerRegistry allocateHandlerRegistry(RegisterDeviceHGUHandler registerDeviceHGUHandler) {
        Map<DeviceType, UseCaseHandler<? extends RegisterDevice, DeviceInventoryEntity>> map = new EnumMap<>(DeviceType.class);
        map.put(DeviceType.HGU, registerDeviceHGUHandler);
        // map.put(DeviceType.REPEATER, registerDeviceRepeaterHandler);
        // map.put(DeviceType.STB, registerDeviceSTBHandler);
        return new HandlerRegistry(map);
    }

    @Bean
    public RegisterDeviceUseCaseHandler registerDeviceUseCaseHandler(HandlerRegistry registry) {
        return new RegisterDeviceUseCaseHandler(registry);
    }

    @Bean
    public UseCaseHandler<DeviceInventoryEntity,DeviceInventoryEntity> deviceInventoryHandler(RegisterDeviceUseCaseHandler registerDeviceUseCaseHandler) {
        return new DefineUseCaseHandler(registerDeviceUseCaseHandler);
    }
}