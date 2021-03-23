package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Currency;

@Projection(name = "currencyProjection", types = Currency.class)
public interface CurrencyProjection {
    Integer getId();

    String getName();

    boolean isActive();
}
