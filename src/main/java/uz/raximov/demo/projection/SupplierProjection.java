package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Supplier;

@Projection(name = "supplierProjection", types = Supplier.class)
public interface SupplierProjection {
    Integer getId();

    String getName();

    boolean isActive();

    String getPhoneNumber();
}
