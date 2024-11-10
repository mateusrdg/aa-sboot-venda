package com.healthmed;

import com.healthmed.infrastructure.adapters.repositories.VeiculoJpaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
@EnableJpaRepositories(basePackageClasses = VeiculoJpaRepository.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
