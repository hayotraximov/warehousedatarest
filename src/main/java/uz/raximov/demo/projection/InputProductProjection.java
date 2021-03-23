package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Input;
import uz.raximov.demo.Entity.Product;

import java.util.Date;

@Projection(name = "inputProductProjection", types = InputProductProjection.class)
public interface InputProductProjection {
    Integer getId();

    Product getProduct();

    double getAmount();

    double getPrice();

    Date getDate();

    Input getInput();
}
