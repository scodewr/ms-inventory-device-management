package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.in;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import br.com.scodewr.inventorydevicemanagment.domain.enums.CharacteristicAttributes;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Log4j2
@RestController
public class DeviceController {

    private UseCaseHandler<DeviceInventoryEntity, ?> handler;

    @PostMapping("/device/register")
    public ResponseEntity<Object> allocateEquipment(@RequestBody DeviceInventoryEntity entity){
        handler.handle(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/device/update")
    public ResponseEntity<Object> updateEquipment(@RequestBody DeviceInventoryEntity entity){
        handler.handle(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/device/uninstall/{deviceId}")
    public ResponseEntity<Object> uninstallEquipment(@PathVariable String deviceId){
        Map<CharacteristicAttributes, String> mapId = new EnumMap<>(CharacteristicAttributes.class);
        mapId.put(CharacteristicAttributes.ID, deviceId);
        var entity = new DeviceInventoryEntity(mapId);
        handler.handle(entity);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
