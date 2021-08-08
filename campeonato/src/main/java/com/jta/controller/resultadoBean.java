package com.jta.controller;

import java.util.ArrayList;
import java.util.Date;

import com.jta.dao.partidoDAO;

public class resultadoBean 
{
	private String strFecha;
	private String equipo_local;
	private String equipo_visitante;
	private int goles_local;
	private int goles_visitante;

	public ArrayList getResultados()
	{
		partidoDAO queriesdao = new partidoDAO();
		
		ArrayList listaEquipo = new ArrayList<>();
		try 
		{
			listaEquipo = queriesdao.getResultados();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return listaEquipo;
	}

	public String getStrFecha() {
		return strFecha;
	}

	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}

	public String getEquipo_local() {
		return equipo_local;
	}

	public void setEquipo_local(String equipo_local) {
		this.equipo_local = equipo_local;
	}

	public String getEquipo_visitante() {
		return equipo_visitante;
	}

	public void setEquipo_visitante(String equipo_visitante) {
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
		return  strFecha + " - " + equipo_local + "(" + goles_local+ ") VS (" +goles_visitante + ") " + equipo_visitante;
	}
	/*public String toString() {
		return "resultadoBean [strFecha=" + strFecha + ", equipo_local=" + equipo_local + ", equipo_visitante="
				+ equipo_visitante + ", goles_local=" + goles_local + ", goles_visitante=" + goles_visitante + "]";
	}*/

	
	

}
