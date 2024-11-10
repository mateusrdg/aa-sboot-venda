package com.healthmed.domain.ports.interfaces;

import com.healthmed.domain.dtos.AuthDTO;
import com.healthmed.domain.dtos.veiculo.VeiculoDTO;

import java.util.List;

public interface VeiculoServicePort {
    VeiculoDTO criaVeiculo(VeiculoDTO veiculoDto);
    VeiculoDTO atualizaVeiculo(Long id, VeiculoDTO veiculoDto);
    List<VeiculoDTO> listaVeiculosDisponiveis();
    List<VeiculoDTO> listaVeiculosVendidos();
    VeiculoDTO compraVeiculo(Long id, Long buyerId);
}

