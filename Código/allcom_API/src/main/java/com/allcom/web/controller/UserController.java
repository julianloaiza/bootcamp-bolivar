package com.allcom.web.controller;

import com.allcom.domain.User;
import com.allcom.domain.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ApiOperation("Obtiene un usuario a partir de su id = (nombre)")
    public ResponseEntity<User> getUser(
            @ApiParam(value = "Nombre del usuario", required = true, example = "Benito Lopez")
            @PathVariable("id") String userId){
        return ResponseEntity.of(userService.getUser(userId));
    }
}