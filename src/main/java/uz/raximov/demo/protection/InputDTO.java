package uz.raximov.demo.protection;

import lombok.Data;

import java.sql.Date;

@Data
public class InputDTO {
    private Integer warehouseId;
    private Integer supplierId;
    private Integer currencyId;
    private Integer facturNumber;
    private Date date;
}
