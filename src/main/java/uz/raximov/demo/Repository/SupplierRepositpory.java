package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Supplier;
import uz.raximov.demo.projection.SupplierProjection;

import java.util.Optional;

@RepositoryRestResource(path = "supplier", excerptProjection = SupplierProjection.class)
public interface SupplierRepositpory extends JpaRepository<Supplier, Integer> {
}
