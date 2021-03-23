package uz.raximov.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.raximov.demo.Entity.template.AbsEntity;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product extends AbsEntity {
    @ManyToOne
    private Category category;

    @OneToOne
    private Attachment attachment;

    @Column(nullable = false)
    private String code = UUID.randomUUID().toString();

    @ManyToOne
    private Measurement measurement;
}
