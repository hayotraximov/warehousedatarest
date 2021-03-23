package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Currency;

import java.util.Optional;

@RepositoryRestResource(path = "currency")
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
