package com.allcom.web.controller;

import com.allcom.domain.Facture;
import com.allcom.domain.service.FactureService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/facturas")
public class FactureController {
    @Autowired
    private FactureService factureService;

    @GetMapping()
    @ApiOperation("Obtiene todas las facturas")
    public ResponseEntity<List<Facture>> getAll() {
        return new ResponseEntity<>(factureService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene una factura por su id")
    public ResponseEntity<Facture> getById(
            @ApiParam(value = "Id de la factura", required = true, example = "1")
            @PathVariable("id") int factureId) {
        return ResponseEntity.of(factureService.getById(factureId));
    }

    @GetMapping("/cliente/{id}")
    @ApiOperation("Obtiene las facturas de un cliente a partir de su id = (nombre)")
    public ResponseEntity<List<Facture>> getByUser(
            @ApiParam(value = "Nombre del usuario", required = true, example = "Benito Lopez")
            @PathVariable("id") String userId){
        return new ResponseEntity<>(factureService.getByUser(userId), HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation("Crea o modifica una factura")
    public ResponseEntity<Facture> save(@RequestBody Facture facture){
        return new ResponseEntity<>(factureService.save(facture), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Elimina una factura existente a partir de su id")
    public ResponseEntity delete(
            @ApiParam(value = "Id de la factura", required = true, example = "1")
            @PathVariable("id") int factureId) {
        return new ResponseEntity(factureService.delete(factureId)
                ? HttpStatus.OK
                : HttpStatus.NOT_FOUND);
    }
}
