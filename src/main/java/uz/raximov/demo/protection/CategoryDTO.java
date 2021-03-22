package uz.raximov.demo.protection;

import lombok.Data;
import uz.raximov.demo.Entity.template.AbsEntity;

@Data
public class CategoryDTO extends AbsEntity {
    private Integer parentId;
}
