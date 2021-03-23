package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Output;
import uz.raximov.demo.Entity.OutputProduct;
import uz.raximov.demo.Entity.Product;

@Projection(name = "outputProductProjection", types = OutputProduct.class)
public interface OutputProductProjection {
    Integer getId();

    Product getProduct();

    double getAmount();

    double getPrice();

    Output getOutput();
}
