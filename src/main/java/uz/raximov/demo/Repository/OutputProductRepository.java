package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.OutputProduct;
import uz.raximov.demo.projection.OutputProductProjection;

@RepositoryRestResource(path = "outputProduct", excerptProjection = OutputProductProjection.class)
public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {
}
