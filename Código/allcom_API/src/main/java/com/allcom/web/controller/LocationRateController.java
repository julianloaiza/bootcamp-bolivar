package com.allcom.web.controller;

import com.allcom.domain.LocationRate;
import com.allcom.domain.service.LocationRateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tarifaubicaciones")
public class LocationRateController {
    @Autowired
    private LocationRateService locationRateService;

    @GetMapping("/{id}")
    @ApiOperation("Obtiene las tarifas por ubicación acordadas para un cliente")
    public ResponseEntity<List<LocationRate>> getByUser(
            @ApiParam(value = "Nombre del usuario", required = true, example = "Benito Lopez")
            @PathVariable("id") String userNameId) {
        return ResponseEntity.of(locationRateService.getByUser(userNameId));
    }
}