package com.grindServer.grindServer.comidas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComidaService {

    private final ComidaRepository comidaRepository;

	@Autowired
	public ComidaService(ComidaRepository comidaRepository) {
		this.comidaRepository = comidaRepository;
	}

    public List<Comida> getComidas() {
		return comidaRepository.findAll();
	}
    
}
