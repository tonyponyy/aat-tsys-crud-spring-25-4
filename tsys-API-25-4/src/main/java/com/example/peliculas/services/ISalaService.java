package com.example.peliculas.services;
import java.util.List;

import com.example.peliculas.dto.Sala;

public interface ISalaService {
	
	//Listar todos
	public List<Sala> listarsalas();
	
	//Listar por id
	public Sala salaXID(Integer id); 
	
	//Guardar
	public Sala guardarsala(Sala sala);
	
	//Actualizar
	public Sala actualizarsala(Sala sala);
	
	//Eliminar
	public void eliminarsala(Integer id);

	
}
