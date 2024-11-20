package com.example.back.services;

import com.example.back.dtos.ContratoDTO;
import com.example.back.entities.Contrato;
import com.example.back.repositories.ContratoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContratoDTO crearContrato(ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        Contrato contratoGuardado = contratoRepository.save(contrato);
        return modelMapper.map(contratoGuardado, ContratoDTO.class);
    }

    public ContratoDTO actualizarContrato(Long id, ContratoDTO contratoDTO) {
        Optional<Contrato> contratoExistente = contratoRepository.findById(id);
        if (contratoExistente.isPresent()) {
            Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
            contrato.setId(id);
            Contrato actualizado = contratoRepository.save(contrato);
            return modelMapper.map(actualizado, ContratoDTO.class);
        }
        throw new RuntimeException("Contrato no encontrado");
    }

    public void eliminarContrato(Long id) {
        contratoRepository.deleteById(id);
    }

    public List<ContratoDTO> obtenerTodos() {
        return contratoRepository.findAll()
                .stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }

    public ContratoDTO obtenerPorId(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        return modelMapper.map(contrato, ContratoDTO.class);
    }
}
