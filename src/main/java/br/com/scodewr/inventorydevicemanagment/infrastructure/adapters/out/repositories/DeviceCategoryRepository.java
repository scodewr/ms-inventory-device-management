package br.com.scodewr.inventorydevicemanagment.infrastructure.adapters.out.repositories;

import br.com.scodewr.inventorydevicemanagment.infrastructure.entities.DeviceCategoryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceCategoryRepository extends JpaRepository<DeviceCategoryJpaEntity, Integer> {
    Optional<DeviceCategoryJpaEntity> findByName(String name);
}
