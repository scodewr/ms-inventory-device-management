package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.repositories;

import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceJpaEntity, Integer> {}
