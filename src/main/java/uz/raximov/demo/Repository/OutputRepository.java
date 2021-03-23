package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Output;
import uz.raximov.demo.projection.OutputProjection;

@RepositoryRestResource(path = "output", excerptProjection = OutputProjection.class)
public interface OutputRepository extends JpaRepository<Output, Integer> {
}
