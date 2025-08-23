package br.com.scodewr.inventorydevicemanagment.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DEVICE")
public class DeviceJpaEntity {

    @Id
    @Column(name = "DEVICE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEVICE_SEQUENCE")
    private Integer deviceId;

    @OneToOne
    @JoinColumn(name = "DEVICE_MODEL_ID")
    private DeviceModelJpaEntity deviceModel;

    @OneToOne
    @JoinColumn(name = "DEVICE_CATEGORY_ID")
    private DeviceCategoryJpaEntity category;

    @Column(name = "DATE_CREATED")
    private Date created;

    @Column(name = "DATA_LAST_UPDATE")
    private Date lastUpdate;
}
