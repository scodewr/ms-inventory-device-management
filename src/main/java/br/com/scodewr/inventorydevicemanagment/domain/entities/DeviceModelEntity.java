package br.com.scodewr.inventorydevicemanagment.domain.entities;

import lombok.Builder;

@Builder
public record DeviceModelEntity(
        Integer deviceModelId,
        String deviceModelName
) {
}
