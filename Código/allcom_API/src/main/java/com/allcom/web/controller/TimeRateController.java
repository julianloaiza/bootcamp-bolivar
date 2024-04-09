package com.allcom.web.controller;

import com.allcom.domain.TimeRate;
import com.allcom.domain.service.TimeRateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tarifatiempos")
public class TimeRateController {
    @Autowired
    private TimeRateService timeRateService;

    @GetMapping("/{id}")
    @ApiOperation("Obtiene las tarifas por rango de tiempos acordadas para un cliente")
    public ResponseEntity<List<TimeRate>> getByUser(
            @ApiParam(value = "Nombre del usuario", required = true, example = "Benito Lopez")
            @PathVariable("id") String userNameId) {
        return ResponseEntity.of(timeRateService.getByUser(userNameId));
    }
}