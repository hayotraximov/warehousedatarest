package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.User;

import java.util.Optional;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Integer> {
}
