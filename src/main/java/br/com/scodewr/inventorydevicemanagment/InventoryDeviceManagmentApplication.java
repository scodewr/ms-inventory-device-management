package br.com.scodewr.inventorydevicemanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class InventoryDeviceManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryDeviceManagmentApplication.class, args);
	}

}
