package com.allcom.web.controller;

import com.allcom.domain.Facture;
import com.allcom.domain.LocationRate;
import com.allcom.domain.Request;
import com.allcom.domain.service.RequestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/solicitudes")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping()
    @ApiOperation("Obtiene todas las solicitudes de revisión de todos los clientes")
    public ResponseEntity<List<Request>> getAll(){
        return new ResponseEntity<>(requestService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene todas las solicitudes de revisión de un solo cliente")
    public ResponseEntity<List<Request>> getByUser(
            @ApiParam(value = "Nombre del usuario", required = true, example = "Benito Lopez")
            @PathVariable("id") String userNameId) {
        return ResponseEntity.of(requestService.getByUser(userNameId));
    }

    @PostMapping()
    @ApiOperation("Crea o modifica una solicitud de revisión")
    public ResponseEntity<Request> save(@RequestBody Request request){

        return new ResponseEntity<>(requestService.save(request), HttpStatus.CREATED);
    }

}
