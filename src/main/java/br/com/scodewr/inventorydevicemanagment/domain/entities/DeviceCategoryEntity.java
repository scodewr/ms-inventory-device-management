package br.com.scodewr.inventorydevicemanagment.domain.entities;

import lombok.Builder;

@Builder
public record DeviceCategoryEntity(
        Integer deviceCategoryId,
        String deviceCategoryName
){}
