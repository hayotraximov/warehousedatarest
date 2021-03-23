package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.InputProduct;
import uz.raximov.demo.projection.InputProductProjection;

@RepositoryRestResource(path = "inputProduct", excerptProjection = InputProductProjection.class)
public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {
}
