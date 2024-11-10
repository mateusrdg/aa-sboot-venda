package com.healthmed.application.adapters.controllers;

import com.healthmed.domain.dtos.veiculo.VeiculoDTO;
import com.healthmed.domain.ports.interfaces.VeiculoServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoServicePort servicePort;

    public VeiculoController(VeiculoServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoDTO createVehicle(@RequestBody @Valid VeiculoDTO veiculoDto) {
        return servicePort.criaVeiculo(veiculoDto);
    }

    @PutMapping("/editar/{id}")
    public VeiculoDTO updateVehicle(@PathVariable Long id, @RequestBody @Valid VeiculoDTO veiculoDto) {
        return servicePort.atualizaVeiculo(id, veiculoDto);
    }

    @GetMapping("/disponiveis")
    public List<VeiculoDTO> listAvailableVehicles() {
        return servicePort.listaVeiculosDisponiveis();
    }

    @GetMapping("/vendidos")
    public List<VeiculoDTO> listSoldVehicles() {
        return servicePort.listaVeiculosVendidos();
    }

    @PostMapping("/comprar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VeiculoDTO purchaseVehicle(@PathVariable Long id, @RequestParam Long buyerId) {
        return servicePort.compraVeiculo(id, buyerId);
    }
}
