package com.allcom.web.controller;

import com.allcom.domain.CharacterRate;
import com.allcom.domain.service.CharacterRateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tarifacaracteres")
public class CharacterRateController {
    @Autowired
    private CharacterRateService characterRateService;

    @GetMapping("/{id}")
    @ApiOperation("Obtiene las tarifas por rango de número de caracteres acordadas para un cliente")
    public ResponseEntity<List<CharacterRate>> getByUser(
            @ApiParam(value = "Nombre del usuario", required = true, example = "Benito Lopez")
            @PathVariable("id") String userNameId) {
        return ResponseEntity.of(characterRateService.getByUser(userNameId));
    }
}