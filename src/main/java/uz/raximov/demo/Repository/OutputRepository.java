package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Output;

@RepositoryRestResource(path = "output")
public interface OutputRepository extends JpaRepository<Output, Integer> {
}
