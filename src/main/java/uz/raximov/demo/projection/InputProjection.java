package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Currency;
import uz.raximov.demo.Entity.Input;
import uz.raximov.demo.Entity.Supplier;
import uz.raximov.demo.Entity.Warehouse;

import java.util.Date;

@Projection(name = "inputProjection", types = Input.class)
public interface InputProjection {
    Integer getId();

    Date getDate();

    Warehouse getWarehouse();

    Supplier getSupplier();

    Currency getCurrency();

    Integer getFactureNumber();

    String getCode();
}
