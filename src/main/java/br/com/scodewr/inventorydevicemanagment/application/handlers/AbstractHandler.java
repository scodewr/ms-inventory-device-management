package br.com.scodewr.inventorydevicemanagment.application.handlers;

import br.com.scodewr.inventorydevicemanagment.application.mappers.DeviceMapper;
import br.com.scodewr.inventorydevicemanagment.application.ports.out.DeviceCategoryPortOut;
import br.com.scodewr.inventorydevicemanagment.application.ports.out.DeviceModelPortOut;
import br.com.scodewr.inventorydevicemanagment.application.ports.out.DevicePortOut;

public abstract class AbstractHandler<D, E, R> {
    protected DeviceMapper<D, E, R> mapper;
    protected DevicePortOut devicePortOut;
    protected DeviceCategoryPortOut deviceCategoryPortOut;
    protected DeviceModelPortOut deviceModelPortOut;
}
