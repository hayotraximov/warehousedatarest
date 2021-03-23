package uz.raximov.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.raximov.demo.Entity.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Warehouse extends AbsEntity {
}
