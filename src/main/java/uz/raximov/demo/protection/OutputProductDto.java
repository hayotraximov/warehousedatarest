package uz.raximov.demo.protection;

import lombok.Data;

@Data
public class OutputProductDto {
    private Integer productId;
    private double amount;
    private double price;
    private Integer outputId;
}
