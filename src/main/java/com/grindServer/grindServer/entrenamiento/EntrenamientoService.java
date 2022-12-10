package com.grindServer.grindServer.entrenamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntrenamientoService {

    private final EntrenamientoRepository entrenamientoRepository;

	@Autowired
	public EntrenamientoService(EntrenamientoRepository entrenamientoRepository) {
		this.entrenamientoRepository = entrenamientoRepository;
	}

	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientoRepository.findAll();
	}

	public void addEntrenamiento(Entrenamiento Entrenamiento) {
		entrenamientoRepository.save(Entrenamiento);
	}

	public void deleteEntrenamiento(Long id) {
		entrenamientoRepository.existsById(id);
		System.out.println("Entrenamiento eliminado");
		entrenamientoRepository.deleteById(id);
	}

	@Transactional
	public void updateEntrenamiento(Long id, String nombre) {

		Entrenamiento ejercicio = entrenamientoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Ejercicio con id " + id + ", no encontrado"));

		if (nombre != null &&
				nombre.length() > 0) {
			ejercicio.setNombre(nombre);
		}


	}
    
}
