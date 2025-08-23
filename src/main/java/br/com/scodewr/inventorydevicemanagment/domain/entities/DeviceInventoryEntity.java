package br.com.scodewr.inventorydevicemanagment.domain.entities;

import br.com.scodewr.inventorydevicemanagment.domain.enums.CharacteristicAttributes;

import java.util.Map;

public record DeviceInventoryEntity(Map<CharacteristicAttributes, String> characteristics) {}
