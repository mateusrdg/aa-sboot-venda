package com.healthmed.domain.adapters.services;

import com.healthmed.application.adapters.controllers.exception.BadRequestException;
import com.healthmed.domain.Veiculo;
import com.healthmed.domain.dtos.veiculo.VeiculoDTO;
import com.healthmed.domain.ports.interfaces.VeiculoServicePort;
import com.healthmed.domain.ports.repositories.VeiculoRepositoryPort;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeiculoServiceImp implements VeiculoServicePort {

    private final VeiculoRepositoryPort repositoryPort;

    public VeiculoServiceImp(VeiculoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public VeiculoDTO criaVeiculo(VeiculoDTO veiculoDto) {
        Veiculo veiculo = new Veiculo(veiculoDto);
        Veiculo savedVeiculo = repositoryPort.save(veiculo);
        return savedVeiculo.toDto();
    }

    @Override
    public VeiculoDTO atualizaVeiculo(Long id, VeiculoDTO veiculoDto) {
        Optional<Veiculo> optionalVeiculo = repositoryPort.findById(id);
        if (optionalVeiculo.isEmpty()) {
            throw new BadRequestException("Veículo não encontrado");
        }

        Veiculo veiculo = optionalVeiculo.get();
        veiculo.setMarca(veiculoDto.getMarca());
        veiculo.setModelo(veiculoDto.getModelo());
        veiculo.setAnoFabricacao(veiculoDto.getAnoFabricacao());
        veiculo.setCor(veiculoDto.getCor());
        veiculo.setPreco(veiculoDto.getPreco());

        Veiculo updatedVeiculo = repositoryPort.save(veiculo);
        return updatedVeiculo.toDto();
    }

    @Override
    public List<VeiculoDTO> listaVeiculosDisponiveis() {
        return repositoryPort.findAllByVendidoFalse().stream()
                .map(Veiculo::toDto)
                .sorted(Comparator.comparing(VeiculoDTO::getPreco))
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDTO> listaVeiculosVendidos() {
        return repositoryPort.findAllByVendidoTrue().stream()
                .map(Veiculo::toDto)
                .sorted(Comparator.comparing(VeiculoDTO::getPreco))
                .collect(Collectors.toList());
    }

    @Override
    public VeiculoDTO compraVeiculo(Long id, Long buyerId) {
        Optional<Veiculo> optionalVeiculo = repositoryPort.findById(id);
        if (optionalVeiculo.isEmpty()) {
            throw new BadRequestException("Veículo não encontrado");
        }

        Veiculo veiculo = optionalVeiculo.get();
        if (veiculo.isVendido()) {
            throw new BadRequestException("Veículo já foi vendido");
        }

        veiculo.setVendido(true);
        Veiculo soldVeiculo = repositoryPort.save(veiculo);
        return soldVeiculo.toDto();
    }

}
