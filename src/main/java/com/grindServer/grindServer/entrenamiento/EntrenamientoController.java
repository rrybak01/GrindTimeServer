package com.grindServer.grindServer.entrenamiento;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "entrenamientos/")
public class EntrenamientoController {
    
    private final EntrenamientoService entrenamientoService;

    @Autowired
    public EntrenamientoController(EntrenamientoService entrenamientoService){
        this.entrenamientoService = entrenamientoService;
    }

    @GetMapping
	public List<Entrenamiento> getEntrenamiento(){
        return entrenamientoService.getEntrenamientos();
    }

    @PostMapping
    public void postEntrenamiento(@RequestBody Entrenamiento entrenamiento){
        entrenamientoService.addEntrenamiento(entrenamiento);
    }

    @DeleteMapping("{id}")
	public void deleteEntrenamiento(@PathVariable("id") Long id){
		entrenamientoService.deleteEntrenamiento(id);
	}

    @PutMapping("{id}")
    public void updateEjercicio(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String nombre){
            entrenamientoService.updateEntrenamiento(id, nombre);
    }

}
