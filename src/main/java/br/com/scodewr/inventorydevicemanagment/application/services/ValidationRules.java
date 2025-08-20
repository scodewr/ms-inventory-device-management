package br.com.scodewr.inventorydevicemanagment.application.services;

import br.com.scodewr.inventorydevicemanagment.domain.entities.AllocateDeviceEntity;
import br.com.scodewr.inventorydevicemanagment.domain.entities.AllocateDeviceHGUEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ValidationRules {

    @SuppressWarnings("unchecked")
    public <T extends AllocateDeviceEntity> T validateAllocateDeviceEntity(AllocateDeviceEntity entity){
        log.info("entidade validada {}", entity);
        return switch (entity.getType()) {
            case HGU -> (T) validateHGU(entity);
            case REPEATER -> (T) validateRepeater(entity);
            case STB -> (T) validateSTB(entity);
            default -> throw new RuntimeException("Tipo de equipamento inválido.");
        };
    }

    private AllocateDeviceHGUEntity validateHGU(AllocateDeviceEntity entity){
        return new AllocateDeviceHGUEntity();
    }

    private <T> T validateRepeater(AllocateDeviceEntity entity){
        throw new UnsupportedOperationException("Validação de repeater não implementada.");
    }

    private <T> T validateSTB(AllocateDeviceEntity entity) {
        throw new UnsupportedOperationException("Validação de STB não implementada.");
    }
}