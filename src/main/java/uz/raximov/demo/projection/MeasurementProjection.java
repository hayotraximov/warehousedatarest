package uz.raximov.demo.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.raximov.demo.Entity.Measurement;

@Projection(name = "measurementProjection", types = Measurement.class)
public interface MeasurementProjection {
    Integer getId();

    String getName();

    boolean isActive();
}
