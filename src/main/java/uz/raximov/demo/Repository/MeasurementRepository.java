package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.raximov.demo.Entity.Measurement;
import uz.raximov.demo.projection.MeasurementProjection;

import java.util.Optional;

@RepositoryRestResource(path = "measurement", excerptProjection = MeasurementProjection.class)
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
