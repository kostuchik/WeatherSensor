package by.pasha.RestApp.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SensorGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SensorIncorrectData> handleException(SensorNotCreatedException exception) {
        SensorIncorrectData data = new SensorIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<SensorIncorrectData> handleException(SensorNotRegisteredException exception) {
        SensorIncorrectData data = new SensorIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
