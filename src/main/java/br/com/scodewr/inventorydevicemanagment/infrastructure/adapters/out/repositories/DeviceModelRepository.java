package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.repositories;

import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceModelJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceModelRepository extends JpaRepository<DeviceModelJpaEntity, Integer> {
    Optional<DeviceModelJpaEntity> findByName(String name);
}
