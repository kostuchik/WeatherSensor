package by.pasha.RestApp.services;

import by.pasha.RestApp.models.Measurement;
import by.pasha.RestApp.models.Sensor;
import by.pasha.RestApp.repositories.MeasurementRepository;
import by.pasha.RestApp.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Integer getRainyDayCount() {
        return measurementRepository.countByRainingTrue();
    }

    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setCreatedAt(LocalDateTime.now());
        Sensor sensor = sensorRepository.findByName(measurement.getSensor().getName()).get();
        measurement.getSensor().setId(sensor.getId());
    }
}
