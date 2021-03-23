package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Attachment;
import uz.raximov.demo.Entity.Category;
import uz.raximov.demo.Entity.Measurement;
import uz.raximov.demo.Entity.Product;

@Projection(name = "productProjection", types = Product.class)
public interface ProductProjection {
    Integer getId();

    String getName();

    boolean isActive();

    Category getCategory();

    Attachment getAttachment();

    String getCode();

    Measurement getMeasurement();
}

