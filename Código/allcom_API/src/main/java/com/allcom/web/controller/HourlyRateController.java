package com.allcom.web.controller;

import com.allcom.domain.Facture;
import com.allcom.domain.HourlyRate;
import com.allcom.domain.service.FactureService;
import com.allcom.domain.service.HourlyRateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tarifahorarios")
public class HourlyRateController {
    @Autowired
    private HourlyRateService hourlyRateService;

    @GetMapping("/{id}")
    @ApiOperation("Obtiene las tarifas por rango de horas acordadas para un cliente")
    public ResponseEntity<List<HourlyRate>> getByUser(
            @ApiParam(value = "Nombre del usuario", required = true, example = "Benito Lopez")
            @PathVariable("id") String userNameId) {
        return ResponseEntity.of(hourlyRateService.getByUser(userNameId));
    }
}
