package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Client;

import java.util.Optional;

@RepositoryRestResource(path = "client")
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
