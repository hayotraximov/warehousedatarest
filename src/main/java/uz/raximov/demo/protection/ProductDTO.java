package uz.raximov.demo.protection;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Integer categoryId;
    private Integer measurementId;
    private Integer attachmentId;
    private boolean active;
}
