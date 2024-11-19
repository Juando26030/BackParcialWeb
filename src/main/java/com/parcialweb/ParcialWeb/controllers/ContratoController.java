package com.parcialweb.ParcialWeb.controllers;


import com.parcialweb.ParcialWeb.DTOs.ContratoDTO;
import com.parcialweb.ParcialWeb.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
    @Autowired
    private ContratoService contratoService;

    // Crear un nuevo contrato
    @PostMapping
    public ResponseEntity<ContratoDTO> crearContrato(@RequestBody ContratoDTO contratoDTO) {
        ContratoDTO nuevoContrato = contratoService.crearContrato(contratoDTO);
        return ResponseEntity.ok(nuevoContrato);
    }

    // Actualizar un contrato existente
    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> actualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        ContratoDTO contratoActualizado = contratoService.actualizarContrato(id, contratoDTO);
        return ResponseEntity.ok(contratoActualizado);
    }

    // Eliminar un contrato por su identificador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable Long id) {
        contratoService.eliminarContrato(id);
        return ResponseEntity.noContent().build();
    }

    // Consultar todos los contratos
    @GetMapping
    public ResponseEntity<List<ContratoDTO>> obtenerTodosLosContratos() {
        List<ContratoDTO> contratos = contratoService.obtenerTodosLosContratos();
        return ResponseEntity.ok(contratos);
    }

    // Consultar un contrato por su identificador
    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> obtenerContratoPorId(@PathVariable Long id) {
        ContratoDTO contrato = contratoService.obtenerContratoPorId(id);
        return ResponseEntity.ok(contrato);
    }
}
