package com.example.peliculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.peliculas.dao.IPeliculaDAO;
import com.example.peliculas.dto.Pelicula;


@Service
public class PeliculaServiceImpl implements IPeliculaService {
	
	@Autowired
	IPeliculaDAO iPeliculaDAO;

	//Listar todos
		public List<Pelicula> listarPeliculas(){
			return iPeliculaDAO.findAll();
		};
		
		
		//Listar por id
		public Pelicula peliculaXID(Integer id) {
			return iPeliculaDAO.findById(id).get();
		}; 
		
		//Guardar
		public Pelicula guardarPelicula(Pelicula Pelicula) {
			return iPeliculaDAO.save(Pelicula);
		};
		
		//Actualizar
		public Pelicula actualizarPelicula(Pelicula Pelicula) {
			return iPeliculaDAO.save(Pelicula);
		};
		
		//Eliminar
		public void eliminarPelicula(Integer id) {
			iPeliculaDAO.deleteById(id);
		}
		 


}
