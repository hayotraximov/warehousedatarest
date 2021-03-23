package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Currency;
import uz.raximov.demo.projection.CurrencyProjection;

import java.util.Optional;

@RepositoryRestResource(path = "currency", excerptProjection = CurrencyProjection.class)
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
