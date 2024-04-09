package com.allcom.web.controller;

import com.allcom.domain.service.ReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reportes")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/generar")
    @ApiOperation("Llama al procedimiento que genera las facturas " +
            "y reportes de ubicación de forma manual")
    public ResponseEntity generarReporte() {
        return new ResponseEntity(reportService.generateReport()
            ? HttpStatus.OK
            : HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
