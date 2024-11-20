package com.example.back.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entities.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
