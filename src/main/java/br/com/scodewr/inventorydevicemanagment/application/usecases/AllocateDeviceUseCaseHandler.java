package br.com.scodewr.inventorydevicemanagment.application.usecases;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.application.services.ValidationRules;
import br.com.scodewr.inventorydevicemanagment.domain.entities.AllocateDeviceEntity;
import lombok.extern.log4j.Log4j2;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AllocateDeviceUseCaseHandler implements UseCaseHandler<AllocateDeviceEntity> {

    private final ValidationRules validationRules;

    private UseCaseHandler<AllocateDeviceEntity> handler;

    @SuppressWarnings("unchecked")
    @Override
    public void setNext(UseCaseHandler<?> nextHandler) {
        this.handler = (UseCaseHandler<AllocateDeviceEntity>) nextHandler;
    }

    @Override
    public void handle(AllocateDeviceEntity entity) {
        AllocateDeviceEntity allocateDeviceEntity = validationRules.validateAllocateDeviceEntity(entity);
        setNext(allocateDeviceEntity.getHandler());
        handler.handle(entity);
    }

}
