package com.jta.model;

public class equipo 
{
	private int id;
	private String nombre;
	private String nombre_entrenador;
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
	public String getNombre_entrenador() {
		return nombre_entrenador;
	}
	public void setNombre_entrenador(String nombre_entrenador) {
		this.nombre_entrenador = nombre_entrenador;
	}
	@Override
	public String toString() {
		return "equipo [id=" + id + ", nombre=" + nombre + ", nombre_entrenador=" + nombre_entrenador + "]";
	}

	
	
}
