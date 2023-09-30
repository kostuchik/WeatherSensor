package by.pasha.RestApp.repositories;

import by.pasha.RestApp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    Integer countByRainingTrue();
}
