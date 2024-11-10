package com.healthmed.infrastructure.configuration;

import com.healthmed.domain.adapters.services.VeiculoServiceImp;
import com.healthmed.domain.ports.interfaces.VeiculoServicePort;
import com.healthmed.domain.ports.repositories.VeiculoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    VeiculoServicePort veiculoServicePort(VeiculoRepositoryPort repositoryPort) {
        return new VeiculoServiceImp(repositoryPort);
    }

}
