package com.grindServer.grindServer.comidas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "comidas/")
public class ComidaController {

    private final ComidaService comidaService;

    @Autowired
    public ComidaController(ComidaService comidaService){
        this.comidaService = comidaService;
    }

    @GetMapping
	public List<Comida> getComidas(){
        return comidaService.getComidas();
    }
    
}
