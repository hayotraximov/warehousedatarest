package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Input;

@RepositoryRestResource(path = "input")
public interface InputRepository extends JpaRepository<Input, Integer> {
}
