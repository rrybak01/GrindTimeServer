/* package com.grindServer.grindServer.usuario;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grindServer.grindServer.alimento.Alimento;
import com.grindServer.grindServer.alimento.AlimentoRespository;
import com.grindServer.grindServer.ejercicio.Ejercicio;
import com.grindServer.grindServer.ejercicio.EjercicioRespository;

@Configuration
public class UsuarioConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(EjercicioRespository ejercicioRepository, AlimentoRespository ar){
        return args -> {
            Ejercicio pressBanca = new Ejercicio(1L, "Press Banca", "");
            Alimento pechugaDePollo = new Alimento("Pechuga de pollo", 10, 35, 7);

            ejercicioRepository.saveAll(List.of(pressBanca));
            ar.save(pechugaDePollo);

        };
    }

}
 */