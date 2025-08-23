package br.com.scodewr.inventorydevicemanagment.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DEVICE_MODEL")
public class DeviceModelJpaEntity {

    public DeviceModelJpaEntity(Integer deviceModelId){
        this.deviceModelId = deviceModelId;
    }

    @Id
    @Column(name = "DEVICE_MODEL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEVICE_MODEL_SEQUENCE")
    private Integer deviceModelId;

    @Column(name = "MODEL_NAME")
    private String name;

    @Column(name = "MODEL_DESCRIPTION")
    private String description;

    @Column(name = "MODEL_MANUFACTURER")
    private String manufacturer;
}
