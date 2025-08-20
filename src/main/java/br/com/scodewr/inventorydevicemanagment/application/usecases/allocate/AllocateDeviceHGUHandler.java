package br.com.scodewr.inventorydevicemanagment.application.usecases.allocate;

import br.com.scodewr.inventorydevicemanagment.application.ports.in.UseCaseHandler;
import br.com.scodewr.inventorydevicemanagment.domain.entities.AllocateDeviceEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class AllocateDeviceHGUHandler implements UseCaseHandler<AllocateDeviceEntity> {

    @Override
    public void setNext(UseCaseHandler<?> nextHandler) {

    }

    @Override
    public void handle(AllocateDeviceEntity entity) {
        log.info("Bateu no allocate HGU");
    }
}
