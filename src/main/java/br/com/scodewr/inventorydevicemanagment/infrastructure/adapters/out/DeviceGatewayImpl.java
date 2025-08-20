package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out;

import br.com.scodewr.inventorydevicemanagment.application.ports.out.EquipmentGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeviceGatewayImpl implements EquipmentGateway {

    @Override
    public Object findById(Object entityOfRepository, Integer id) {
        return null;
    }

    @Override
    public Object save(Object entityOfRepository) {
        return null;
    }

    @Override
    public Object update(Object entityOfRepository) {
        return null;
    }

    @Override
    public void delete(Object entityOfRepository) {

    }

    @Override
    public Object findByQuery(String query, Object entityOfRepository) {
        return null;
    }
}
