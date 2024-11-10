package com.healthmed.domain.dtos.veiculo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Year;

@NoArgsConstructor
@Getter
@Setter
public class VeiculoDTO {

    @NotNull(message = "O campo 'marca' não pode ser nulo")
    @NotBlank(message = "O campo 'marca' não pode estar em branco")
    private String marca;

    @NotNull(message = "O campo 'modelo' não pode ser nulo")
    @NotBlank(message = "O campo 'modelo' não pode estar em branco")
    private String modelo;

    @NotNull(message = "O campo 'ano de fabricação' não pode ser nulo")
    private Year anoFabricacao;

    @NotNull(message = "O campo 'cor' não pode ser nulo")
    @NotBlank(message = "O campo 'cor' não pode estar em branco")
    private String cor;

    @NotNull(message = "O campo 'preço' não pode ser nulo")
    private BigDecimal preco;

    private boolean vendido;

    public VeiculoDTO(String marca, String modelo, Year anoFabricacao, String cor, BigDecimal preco, boolean vendido) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.preco = preco;
        this.vendido = vendido;
    }
}
