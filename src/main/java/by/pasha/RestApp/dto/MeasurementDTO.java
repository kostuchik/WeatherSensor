package by.pasha.RestApp.dto;

import by.pasha.RestApp.models.Sensor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;


public class MeasurementDTO {
    @NotNull(message = "Temperature should not be empty")
    @Min(value = -100, message = "Temperature should be greater than or equal to -100")
    @Max(value = 100, message = "Temperature should be less than or equal to 100")
    private Double value;
    @NotNull(message = "Field should not be empty")
    private Boolean raining;
    private LocalDateTime createdAt;
    @NotNull(message = "Sensor should not be empty")
    private Sensor sensor;

    public MeasurementDTO() {
    }

    public MeasurementDTO(double value, Boolean raining, LocalDateTime createdAt, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.createdAt = createdAt;
        this.sensor = sensor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
