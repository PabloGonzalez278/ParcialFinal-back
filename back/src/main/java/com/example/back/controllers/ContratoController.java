package com.example.back.controllers;

import com.example.back.dtos.ContratoDTO;
import com.example.back.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ContratoDTO crearContrato(@RequestBody ContratoDTO contratoDTO) {
        return contratoService.crearContrato(contratoDTO);
    }

    @PutMapping("/{id}")
    public ContratoDTO actualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        return contratoService.actualizarContrato(id, contratoDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarContrato(@PathVariable Long id) {
        contratoService.eliminarContrato(id);
    }

    @GetMapping
    public List<ContratoDTO> obtenerTodos() {
        return contratoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ContratoDTO obtenerPorId(@PathVariable Long id) {
        return contratoService.obtenerPorId(id);
    }
}
