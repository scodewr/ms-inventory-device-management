package br.com.scodewr.inventorydevicemanagment.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class IDMException extends RuntimeException {

    private final String reasonCode;
    private final String message;
    private final String detail;

    public IDMException(){
        this.reasonCode = null;
        this.message = null;
        this.detail = null;
    }
}
