package br.com.scodewr.inventorydevicemanagment.application.services;

import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDevice;
import br.com.scodewr.inventorydevicemanagment.domain.dto.RegisterDeviceHGU;
import br.com.scodewr.inventorydevicemanagment.domain.exceptions.IDMException;
import br.com.scodewr.inventorydevicemanagment.domain.messages.IDMStatusMessages;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class ValidationRules {

    @SuppressWarnings("unchecked")
    public <T extends RegisterDevice> T validateAllocateDeviceEntity(RegisterDevice entity){
        log.info("entidade validada {}", entity);
        return switch (entity.getType()) {
            case HGU -> (T) validateHGU(entity);
            case REPEATER -> (T) validateRepeater(entity);
            case STB -> (T) validateSTB(entity);
            default -> throw new IDMException(IDMStatusMessages.IDM_402.getCode(), IDMStatusMessages.IDM_402.getMessage(), "Tipo de equipamento inválido.");
        };
    }

    private RegisterDeviceHGU validateHGU(RegisterDevice entity){
        log.info("Validating entity: {}", entity);
        var registerDeviceHGU = new RegisterDeviceHGU();
        registerDeviceHGU.setDeviceCategoryName(entity.getDeviceCategoryName());
        registerDeviceHGU.setDeviceModelName(entity.getDeviceModelName());
        return registerDeviceHGU;
    }

    private <T> T validateRepeater(RegisterDevice entity){
        throw new UnsupportedOperationException("Validação de repeater não implementada.");
    }

    private <T> T validateSTB(RegisterDevice entity) {
        throw new UnsupportedOperationException("Validação de STB não implementada.");
    }
}