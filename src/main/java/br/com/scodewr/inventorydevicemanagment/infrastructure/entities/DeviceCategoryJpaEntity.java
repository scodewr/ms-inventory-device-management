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
@Table(name = "DEVICE_CATEGORY")
public class DeviceCategoryJpaEntity {

    @Id
    @Column(name = "DEVICE_CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEVICE_CATEGORY_SEQUENCE")
    private Integer deviceCategoryId;

    @Column(name = "DEVICE_CATEGORY_NAME")
    private String name;

    public DeviceCategoryJpaEntity(Integer categoryId){
        this.deviceCategoryId = categoryId;
    }

}
