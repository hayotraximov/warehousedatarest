package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Input;
import uz.raximov.demo.projection.InputProjection;

@RepositoryRestResource(path = "input", excerptProjection = InputProjection.class)
public interface InputRepository extends JpaRepository<Input, Integer> {
}
