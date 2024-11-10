package com.healthmed.infrastructure.adapters.repositories;

import com.healthmed.domain.Veiculo;
import com.healthmed.domain.ports.repositories.VeiculoRepositoryPort;
import com.healthmed.infrastructure.adapters.entities.VeiculoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VeiculoRepository implements VeiculoRepositoryPort {

    private final VeiculoJpaRepository jpaRepository;

    public VeiculoRepository(VeiculoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public Optional<Veiculo> findById(Long id) {
        return jpaRepository.findById(id).map(VeiculoEntity::toDomain);
    }

    @Override
    public Veiculo save(Veiculo veiculo) {
        VeiculoEntity entity = jpaRepository.save(new VeiculoEntity(veiculo));
        return entity.toDomain();
    }

    @Override
    public List<Veiculo> findAllByVendidoFalse() {
        return jpaRepository.findAllByVendidoFalse().stream()
                .map(VeiculoEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Veiculo> findAllByVendidoTrue() {
        return jpaRepository.findAllByVendidoTrue().stream()
                .map(VeiculoEntity::toDomain)
                .collect(Collectors.toList());
    }
}
