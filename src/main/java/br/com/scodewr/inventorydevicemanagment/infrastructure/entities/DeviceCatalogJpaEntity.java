package br.com.scodewr.inventorydevicemanagment.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "DEVICE_CATALOG")
public class DeviceCatalogJpaEntity {

    @Id
    @Column(name = "DEVICE_CATALOG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEVICE_CATALOG_SEQUENCE")
    private Integer catalogId;

    @OneToOne
    @JoinColumn(name = "DEVICE_MODEL_ID")
    private DeviceModelJpaEntity deviceModel;

    @OneToOne
    @JoinColumn(name = "DEVICE_CATEGORY_ID")
    private DeviceCategoryJpaEntity category;

    private Integer totalDeviceInventory;
}
