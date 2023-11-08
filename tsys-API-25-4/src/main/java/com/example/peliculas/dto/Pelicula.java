package com.example.peliculas.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Peliculas")
public class Pelicula {

	// Atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre") // no es del todo necesario
	private String nombre;
	private int calificacion;
	@JoinColumn(name = "pelicula") // tabla foranea
	@OneToMany()
	private List<Sala> salas;

	// Constructores de clase
	public Pelicula() {

	}

	public Pelicula(int id, String nombre, int calificacion, List<Sala> salas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calificacion = calificacion;
		this.salas = salas;
	}







	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public String getNombre() {
		return nombre;
	}







	public void setNombre(String nombre) {
		this.nombre = nombre;
	}







	public int getCalificacion() {
		return calificacion;
	}







	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}







	public List<Sala> getSalas() {
		return salas;
	}







	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}







	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", calificacion=" + calificacion + ", salas=" + salas
				+ "]";
	}







	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	public List<Sala> getsalas() {
		return salas;
	}

	public void setsalas(List<Sala> salas) {
		this.salas = salas;
	}





}
