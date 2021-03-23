package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Supplier;

import java.util.Optional;

@RepositoryRestResource(path = "supplier")
public interface SupplierRepositpory extends JpaRepository<Supplier, Integer> {
}
