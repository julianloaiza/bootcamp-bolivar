package com.allcom.web.controller;

import com.allcom.domain.Facture;
import com.allcom.domain.Location;
import com.allcom.domain.service.LocationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ubicaciones")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping()
    @ApiOperation("Obtiene el historial de reportes por ubicación")
    public ResponseEntity<List<Location>> getAll() {
        return new ResponseEntity<>(locationService.getAll(), HttpStatus.OK);
    }

}
