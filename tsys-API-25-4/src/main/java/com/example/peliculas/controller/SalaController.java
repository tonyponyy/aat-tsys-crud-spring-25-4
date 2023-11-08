package com.example.peliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.peliculas.dto.Pelicula;
import com.example.peliculas.dto.Sala;
import com.example.peliculas.services.SalaServiceImpl;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@RestController
@RequestMapping("/salas")
public class SalaController {

	@Autowired
	SalaServiceImpl salaServideImpl;
	
	@GetMapping("/all")
	public List<Sala> listarsalas(){
		return salaServideImpl.listarsalas();
	}
	

	@PostMapping("/add")
	public Sala salvarsala(@RequestBody Sala sala) {
		return salaServideImpl.guardarsala(sala);
	}
	
	
	@GetMapping("/{id}")
	public Sala salaXID(@PathVariable(name="id") Integer id) {
		
		Sala sala_xid= new Sala();
		
		sala_xid=salaServideImpl.salaXID(id);
		
		//System.out.println("sala XID: "+sala_xid);
		
		return sala_xid;
	}
	
	@PutMapping("/{id}")
	public Sala actualizarsala(@PathVariable(name="id")Integer id,@RequestBody Sala sala) {
		
		Sala sala_seleccionado= new Sala();
		Sala sala_actualizado= new Sala();
		
		sala_seleccionado= salaServideImpl.salaXID(id);
		
		sala_seleccionado.setNombre(sala.getNombre());
		sala_seleccionado.setPelicula(sala.getPelicula());
		
		sala_actualizado = salaServideImpl.actualizarsala(sala_seleccionado);
		
		System.out.println("El sala actualizado es: "+ sala_actualizado);
		
		return sala_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarsala(@PathVariable(name="id")Integer id) {
		salaServideImpl.eliminarsala(id);
		System.out.println("sala eliminado");
	}
	
	
}