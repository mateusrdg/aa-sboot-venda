package com.healthmed.domain;

import com.healthmed.domain.dtos.veiculo.VeiculoDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Year;

@Setter
@Getter
public class Veiculo {

    private Long id;
    private String marca;
    private String modelo;
    private Year anoFabricacao;
    private String cor;
    private BigDecimal preco;
    private boolean vendido;

    public Veiculo() {
    }

    public Veiculo(Long id, String marca, String modelo, Year anoFabricacao, String cor, BigDecimal preco, boolean vendido) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.preco = preco;
        this.vendido = vendido;
    }

    public Veiculo(VeiculoDTO veiculoDTO) {
        this.marca = veiculoDTO.getMarca();
        this.modelo = veiculoDTO.getModelo();
        this.anoFabricacao = veiculoDTO.getAnoFabricacao();
        this.cor = veiculoDTO.getCor();
        this.preco = veiculoDTO.getPreco();
        this.vendido = veiculoDTO.isVendido();
    }

    public VeiculoDTO toDto() {
        return new VeiculoDTO(this.marca, this.modelo, this.anoFabricacao, this.cor, this.preco, this.vendido);
    }
}
