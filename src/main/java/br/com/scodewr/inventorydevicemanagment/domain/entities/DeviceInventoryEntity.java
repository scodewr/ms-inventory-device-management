package br.com.scodewr.inventorydevicemanagment.domain.entities;

import br.com.scodewr.inventorydevicemanagment.domain.enums.CharacteristicAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceInventoryEntity {
    private List<Map<CharacteristicAttributes, String>> characteristics;

    public DeviceInventoryEntity(List<Map<CharacteristicAttributes, String>> characteristics) {
        this.characteristics = characteristics;
    }

    public List<Map<CharacteristicAttributes, String>> getCharacteristics(){
        if(null == this.characteristics){
            List<Map<CharacteristicAttributes, String>> list = new ArrayList<>();
            Map<CharacteristicAttributes, String> map = new HashMap<>();
            map.put(CharacteristicAttributes.ID, "1234");
            map.put(CharacteristicAttributes.TYPE, "HGU");
            list.add(map);
            return list;
        }
        return this.characteristics;
    }
}
