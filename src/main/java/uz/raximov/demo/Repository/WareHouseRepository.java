package uz.raximov.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Warehouse;
import uz.raximov.demo.projection.WarehouseProjection;

@RepositoryRestResource(path = "warehouse", excerptProjection = WarehouseProjection.class)
public interface WareHouseRepository  extends JpaRepository<Warehouse, Integer> {
}
