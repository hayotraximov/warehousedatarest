package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.User;
import uz.raximov.demo.Entity.Warehouse;

import java.util.Set;

@Projection(name = "userProjection", types = User.class)
public interface UserProjection {
    Integer getId();

    String getFirstName();

    String getLastName();

    String getPhoneNumber();

    String getCode();

    boolean isActive();

    Set<Warehouse> getWarehouseSet();
}
