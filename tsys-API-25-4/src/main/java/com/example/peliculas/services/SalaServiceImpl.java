package com.example.peliculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.peliculas.dao.ISalaDAO;
import com.example.peliculas.dto.Sala;


@Service
public class SalaServiceImpl implements ISalaService {
	
	@Autowired
	ISalaDAO isalaDAO;

	//Listar todos
		public List<Sala> listarsalas(){
			return isalaDAO.findAll();
		};
		
		
		//Listar por id
		public Sala salaXID(Integer id) {
			return isalaDAO.findById(id).get();
		}; 
		
		//Guardar
		public Sala guardarsala(Sala sala) {
			return isalaDAO.save(sala);
		};
		
		//Actualizar
		public Sala actualizarsala(Sala sala) {
			return isalaDAO.save(sala);
		};
		
		//Eliminar
		public void eliminarsala(Integer id) {
			isalaDAO.deleteById(id);
		}
		 


}
