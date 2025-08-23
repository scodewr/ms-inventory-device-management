package br.com.scodewr.inventorydevicemanagment.domain.entities;

import lombok.Builder;

import java.util.Date;

@Builder
public record DeviceEntity(
        Integer deviceId,
        Integer deviceModelId,
        String deviceModelName,
        Integer deviceCategoryId,
        String deviceCategoryName,
        Date created,
        Date lastUpdate
) {}
