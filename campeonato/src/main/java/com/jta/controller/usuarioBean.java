package com.jta.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jta.dao.adm_usuarioDAO;
import com.jta.model.PlantillaController;

@ManagedBean (name="usuarioBean")
@SessionScoped

public class usuarioBean 
{
	private int id;
	private String id_usuario;
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String correo_electronico;
	private String clave;
	private String clave2;

	
	
	public String ingresarUsuario() 
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		FacesContext context = FacesContext.getCurrentInstance(); 
		String strUsuario;
		
		String strIdCredito;
		String strFechaCompromisoFinal = "";
		String strFechaGrabarGestion = "";
		String strMensajeError ="";
		
		PlantillaController pc = new PlantillaController();
		String strUsuarioLogueado = pc.getUsuarioLogueado();
		boolean bolIngreso= false;
		

		adm_usuarioDAO queriesdao = new adm_usuarioDAO();
		try 
		{
				
			if(strMensajeError.equals(""))
			{
				bolIngreso =queriesdao.crear_usuario(id_usuario.toUpperCase(), primer_nombre.toUpperCase(), segundo_nombre.toUpperCase(), 
										primer_apellido.toUpperCase(), segundo_apellido.toUpperCase(), correo_electronico, clave);
				
			}
		}
		catch(Exception e) 
		{ 
			String msg=  "error "+e;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
		
		if (bolIngreso) 
		{
			  
			  FacesContext.getCurrentInstance().addMessage(null, new
			  FacesMessage("Fue Ingresado el usuario "+ id_usuario.toUpperCase() + " " + primer_nombre)); //HttpSession session =
			  /*SessionUtils.getSession(); 
			  HttpSession session = SessionUtils.getSession();*/
			  
			  return "nuevo_usuario"; 
		} 
		else if(!strMensajeError.equals(""))
		{
			FacesContext.getCurrentInstance().addMessage( null, new
					  FacesMessage(FacesMessage.SEVERITY_WARN,
							  strMensajeError,
							  strMensajeError));
					  
			return "nuevo_usuario"; 
		}
		else {
			  
			  FacesContext.getCurrentInstance().addMessage( null, new
			  FacesMessage(FacesMessage.SEVERITY_WARN,
			  "ERROR INTERNO APLICACION - COMUNICAR ADMINISTRADOR",
			  "ERROR INTERNO APLICACION - COMUNICAR ADMINISTRADOR"));
			  
			  return "nuevo_usuario"; 
		}
		
		
		//return "gestionar";
	}
	
	
	public List getUsuarios()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		adm_usuarioDAO queriesdao = new adm_usuarioDAO();
		
		//List<Vehiculo> listaVehiculos2 = new ArrayList();
		//List<ays_ges_detalle_tarea> listaTareas = new ArrayList<>();
		List listaTercero = new ArrayList<>();
		try 
		{
			listaTercero = queriesdao.getUsuario();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return listaTercero;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getPrimer_nombre() {
		return primer_nombre;
	}
	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}
	public String getSegundo_nombre() {
		return segundo_nombre;
	}
	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}
	public String getPrimer_apellido() {
		return primer_apellido;
	}
	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}
	public String getSegundo_apellido() {
		return segundo_apellido;
	}
	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getClave2() {
		return clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}
	
	
	
	
}
