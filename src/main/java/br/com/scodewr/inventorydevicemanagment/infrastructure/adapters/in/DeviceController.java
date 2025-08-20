package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.in;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.domain.entities.DeviceInventoryEntity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Log4j2
@RestController
public class DeviceController {

    private UseCaseHandler<DeviceInventoryEntity> handler;

    @PostMapping("/device/allocate")
    public ResponseEntity<Object> allocateEquipment(DeviceInventoryEntity entity){
        handler.handle(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/device/install")
    public ResponseEntity<Object> installEquipment(DeviceInventoryEntity entity){
        handler.handle(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/device/update")
    public ResponseEntity<Object> updateEquipment(DeviceInventoryEntity entity){
        handler.handle(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/device/deallocate")
    public ResponseEntity<Object> deallocateEquipment(DeviceInventoryEntity entity){
        handler.handle(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/device/uninstall")
    public ResponseEntity<Object> uninstallEquipment(DeviceInventoryEntity entity){
        handler.handle(entity);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
