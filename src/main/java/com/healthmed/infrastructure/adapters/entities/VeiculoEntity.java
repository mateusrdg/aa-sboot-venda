package com.healthmed.infrastructure.adapters.entities;

import com.healthmed.domain.Veiculo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Year;

@Entity
@Table(name = "veiculos")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marca;
    private String modelo;

    @Column(name = "ano")
    private Year anoFabricacao;

    private String cor;
    private BigDecimal preco;

    @Column(name = "vendido")
    private boolean vendido;

    public VeiculoEntity() {
    }

    public VeiculoEntity(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.anoFabricacao = veiculo.getAnoFabricacao();
        this.cor = veiculo.getCor();
        this.preco = veiculo.getPreco();
        this.vendido = veiculo.isVendido();
    }

    public Veiculo toDomain() {
        return new Veiculo(this.id, this.marca, this.modelo, this.anoFabricacao, this.cor, this.preco, this.vendido);
    }
}
