package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Product;
import uz.raximov.demo.projection.ProductProjection;

@RepositoryRestResource(path = "product", excerptProjection = ProductProjection.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
