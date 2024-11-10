package com.healthmed.infrastructure.adapters.repositories;

import com.healthmed.infrastructure.adapters.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoJpaRepository extends JpaRepository<VeiculoEntity, Long> {

    List<VeiculoEntity> findAllByVendidoFalse();
    List<VeiculoEntity> findAllByVendidoTrue();
}
