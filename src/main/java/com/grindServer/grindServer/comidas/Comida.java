package com.grindServer.grindServer.comidas;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.grindServer.grindServer.alimento.Alimento;

@Entity
@Table(name = "comidas")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @JoinTable(
        name = "alimentoscomidas",
        joinColumns = @JoinColumn(name = "idalimento", nullable = false),
        inverseJoinColumns = @JoinColumn(name="idcomida", nullable = false)
    )
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Alimento> alimento;

    public Comida() {
    }

    public Comida(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Set<Alimento> getAlimento(){
        return alimento;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
