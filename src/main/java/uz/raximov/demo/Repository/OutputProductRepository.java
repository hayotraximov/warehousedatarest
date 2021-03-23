package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.OutputProduct;

@RepositoryRestResource(path = "outputProduct")
public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {
}
