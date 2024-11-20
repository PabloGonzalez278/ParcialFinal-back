package com.example.back.dtos;

import lombok.Data;

@Data
public class ContratoDTO {
    private Long id;
    private String identificador;
    private Double valor;
    private String nombreContratante;
    private String documentoContratante;
    private String nombreContratista;
    private String documentoContratista;
    private String fechaInicial; 
    private String fechaFinal;
}
