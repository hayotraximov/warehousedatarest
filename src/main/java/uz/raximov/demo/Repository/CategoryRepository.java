package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Category;

import java.util.Optional;

@RepositoryRestResource(path = "category")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
