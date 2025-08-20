package br.com.scodewr.inventorydevicemanagment.application.ports.out;

public interface EquipmentGateway {
    Object findById(Object entityOfRepository, Integer id);
    Object save(Object entityOfRepository);
    Object update(Object entityOfRepository);
    void delete(Object entityOfRepository);
    Object findByQuery(String query, Object entityOfRepository);
}
