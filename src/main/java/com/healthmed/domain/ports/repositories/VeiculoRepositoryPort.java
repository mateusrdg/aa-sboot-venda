package com.healthmed.domain.ports.repositories;

import com.healthmed.domain.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepositoryPort {
    Optional<Veiculo> findById(Long id);
    Veiculo save(Veiculo veiculo);
    List<Veiculo> findAllByVendidoFalse();
    List<Veiculo> findAllByVendidoTrue();
}
