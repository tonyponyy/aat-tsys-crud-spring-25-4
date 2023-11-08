package com.example.peliculas.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.peliculas.dto.Pelicula;


public interface IPeliculaDAO extends JpaRepository<Pelicula,Integer> {



	
}
