package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Category;

@Projection(name = "categoryProjection", types = Category.class)
public interface CategoryProjection {
    Integer getId();

    String getName();

    boolean isActive();

    Category getCategory();
}
