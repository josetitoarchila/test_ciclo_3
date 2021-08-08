package com.jta.model;

import java.util.Date;

public class partido 
{
	private int id;
	private Date fecha;
	private int equipo_local;
	private int equipo_visitante;
	private int goles_local;
	private int goles_visitante;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getEquipo_local() {
		return equipo_local;
	}
	public void setEquipo_local(int equipo_local) {
		this.equipo_local = equipo_local;
	}
	public int getEquipo_visitante() {
		return equipo_visitante;
	}
	public void setEquipo_visitante(int equipo_visitante) {
		this.equipo_visitante = equipo_visitante;
	}
	public int getGoles_local() {
		return goles_local;
	}
	public void setGoles_local(int goles_local) {
		this.goles_local = goles_local;
	}
	public int getGoles_visitante() {
		return goles_visitante;
	}
	public void setGoles_visitante(int goles_visitante) {
		this.goles_visitante = goles_visitante;
	}
	@Override
	public String toString() {
		return "partido [id=" + id + ", fecha=" + fecha + ", equipo_local=" + equipo_local + ", equipo_visitante="
				+ equipo_visitante + ", goles_local=" + goles_local + ", goles_visitante=" + goles_visitante + "]";
	}
	
	
	

	
}
