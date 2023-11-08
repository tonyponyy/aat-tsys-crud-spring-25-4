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
import com.example.peliculas.services.PeliculaServiceImpl;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

	@Autowired
	PeliculaServiceImpl PeliculaServideImpl;
	
	@GetMapping("/all")
	public List<Pelicula> listarPeliculas(){
		return PeliculaServideImpl.listarPeliculas();
	}
	

	@PostMapping("/add")
	public Pelicula salvarPelicula(@RequestBody Pelicula Pelicula) {
		return PeliculaServideImpl.guardarPelicula(Pelicula);
	}
	
	
	@GetMapping("/{id}")
	public Pelicula PeliculaXID(@PathVariable(name="id") Integer id) {
		
		Pelicula Pelicula_xid= new Pelicula();
		
		Pelicula_xid=PeliculaServideImpl.peliculaXID(id);
		
		//System.out.println("Pelicula XID: "+Pelicula_xid);
		
		return Pelicula_xid;
	}
	
	@PutMapping("/{id}")
	public Pelicula actualizarPelicula(@PathVariable(name="id")Integer id,@RequestBody Pelicula Pelicula) {
		
		Pelicula Pelicula_seleccionado= new Pelicula();
		Pelicula Pelicula_actualizado= new Pelicula();
		
		Pelicula_seleccionado= PeliculaServideImpl.peliculaXID(id);
		
		Pelicula_seleccionado.setNombre(Pelicula.getNombre());
		Pelicula_seleccionado.setCalificacion(Pelicula.getCalificacion());
		Pelicula_seleccionado.setSalas(Pelicula.getSalas());

		
		Pelicula_actualizado = PeliculaServideImpl.actualizarPelicula(Pelicula_seleccionado);
		
		System.out.println("El Pelicula actualizado es: "+ Pelicula_actualizado);
		
		return Pelicula_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarPelicula(@PathVariable(name="id")Integer id) {
		PeliculaServideImpl.eliminarPelicula(id);
		System.out.println("Pelicula eliminado");
	}
	
	
}