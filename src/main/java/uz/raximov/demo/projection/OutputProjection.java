package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Client;
import uz.raximov.demo.Entity.Currency;
import uz.raximov.demo.Entity.Output;
import uz.raximov.demo.Entity.Warehouse;

import java.util.Date;

@Projection(name = "outputProjection", types = Output.class)
public interface OutputProjection {
    Integer getId();

    Date getDate();

    Warehouse getWarehouse();

    Currency getCurrency();

    Integer getFactureNumber();

    String getCode();

    Client getClient();
}
