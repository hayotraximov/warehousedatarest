package uz.raximov.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    private String code = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String password;

    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<Warehouse> warehouseSet;
}
