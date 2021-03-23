package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Warehouse;

@Projection(types = {Warehouse.class}, name = "warehouseProtection")
public interface WarehouseProjection {
     Integer getId();

     String getName();

     boolean isActive();
}
