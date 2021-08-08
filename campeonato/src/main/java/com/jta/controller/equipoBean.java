package com.jta.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.jta.dao.equipoDAO;
import com.jta.model.PlantillaController;



public class equipoBean 
{
	private int id;
	private String nombre;
	private String nombre_entrenador;
	
	public boolean ingresarEquipo() 
	{
		String strUsuario;
		
		String strIdCredito;
		String strMensajeError ="";
		
		PlantillaController pc = new PlantillaController();
		String strUsuarioLogueado = pc.getUsuarioLogueado();
		boolean bolExistePlaca = false;
		equipoDAO queriesdao = new equipoDAO();
		
		boolean bolIngreso= false;
		//QueriesDAO queriesdao = new QueriesDAO();
		try 
		{
				
			if(strMensajeError.equals(""))
			{
				bolIngreso =queriesdao.crear_equipo(nombre, nombre_entrenador);
				
			}
		}
		catch(Exception e) 
		{ 
			String msg=  "error "+e;
            System.out.println("fue ingresado correctamente ");
		}
		
		if (bolIngreso) 
		{
			  return true; 
		} 
		else if(!strMensajeError.equals(""))
		{
			return false; 
		}
		else {
			  return false; 
		}
		
		
		//return "gestionar";
	}
	


	
	public boolean modificarEquipo() 
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		FacesContext context = FacesContext.getCurrentInstance(); 
		String strUsuario;
		String strIdDeudor;
		String strMensajeError=""; 
		
		
		boolean bolIngreso= false;
		equipoDAO queriesdao = new equipoDAO();
		try 
		{
			if(strMensajeError.equals(""))
			{

				//bolIngreso =queriesdao.modificar_sucursal(nombre, id_gerente, telefono, telefono2, direccion, correo_electronico, ciudad, id);
				bolIngreso =queriesdao.modificar_equipo(nombre, nombre_entrenador, id);
			}
		}
		catch(Exception e) 
		{ 
			String msg=  "error "+e;
            System.out.println("error actualizando equipo "+e);
		}
		
		if (bolIngreso) 
		{
			  
			  return true; 
		} 
		else if(!strMensajeError.equals(""))
		{
			return false; 
		}
		else {
			  
			  return false; 
		}
		
		
		//return "gestionar";
	}
	
	public boolean eliminarEquipo() 
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		FacesContext context = FacesContext.getCurrentInstance(); 
		String strUsuario;
		String strIdDeudor;
		String strMensajeError=""; 
		
		
		boolean bolIngreso= false;
		equipoDAO queriesdao = new equipoDAO();
		try 
		{
			if(strMensajeError.equals(""))
			{

				//bolIngreso =queriesdao.modificar_sucursal(nombre, id_gerente, telefono, telefono2, direccion, correo_electronico, ciudad, id);
				bolIngreso =queriesdao.eliminar_equipo(id);
			}
		}
		catch(Exception e) 
		{ 
			String msg=  "error "+e;
            System.out.println("error eliminando equipo "+e);
		}
		
		if (bolIngreso) 
		{
			  
			  return true; 
		} 
		else if(!strMensajeError.equals(""))
		{
			return false; 
		}
		else {
			  
			  return false; 
		}
		
		
		//return "gestionar";
	}
	
	
	public ArrayList getEquipos()
	{
		equipoDAO queriesdao = new equipoDAO();
		
		ArrayList listaEquipo = new ArrayList<>();
		try 
		{
			listaEquipo = queriesdao.getEquipo();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return listaEquipo;
	}
	
	public ArrayList getEquipoxId(int parIdModificar)
	{
		equipoDAO queriesdao = new equipoDAO();
		
		ArrayList listaEquipo = new ArrayList<>();
		try 
		{
			listaEquipo = queriesdao.getEquipoxId(parIdModificar);
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return listaEquipo;
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
