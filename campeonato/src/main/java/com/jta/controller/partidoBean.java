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

import com.jta.dao.equipoDAO;
import com.jta.dao.partidoDAO;
import com.jta.model.PlantillaController;


@ManagedBean (name="partidoBean")
@SessionScoped


public class partidoBean {

	private int id;
	private Date fecha;
	private String strFecha;
	private int equipo_local;
	private int equipo_visitante;
	private int goles_local;
	private int goles_visitante;
	
	private String strEquipoLocal;
	private String strEquipoVisitante;
	
	static List listaEquipos = new ArrayList<>();
	
	// Generated by Map
	private static Map<String, Object> EquiposValue;
	static {
		EquiposValue = new LinkedHashMap<String, Object>();

		partidoDAO queriesdao = new partidoDAO();
		try 
		{
			listaEquipos = queriesdao.getEquipos();
			for (Iterator i = listaEquipos.iterator(); i.hasNext();) {

				ArrayList al_fila = (ArrayList) i.next();
				String strCodigo = (String) al_fila.get(0);
				String strDescripcion = (String) al_fila.get(1);

				EquiposValue.put(strDescripcion, strCodigo);
			}
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		} 
	
	
	}
	
	
	
	public String ingresarPartido() 
	{
		String strUsuario;
		String strIdCredito;
		String strMensajeError ="";
		
		boolean bolExistePlaca = false;
		partidoDAO queriesdao = new partidoDAO();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date datFechaNull =null;
		String strFechanull = "1900-01-01";
		try
		{
			datFechaNull = new SimpleDateFormat("yyyy-MM-dd").parse(strFechanull);	
		}
		catch(Exception e)
		{
			System.out.println("error en bean con fechas null"+e);
		}
		
		
		
        if(fecha==null)
        {
        	
        	strFecha = format.format(datFechaNull);
        	fecha = datFechaNull;
        }
        else
        {
        	strFecha = format.format(fecha);
        }
		
		System.out.println("strFecha"+strFecha);
		
		boolean bolIngreso= false;
		//QueriesDAO queriesdao = new QueriesDAO();
		try 
		{
				
				bolIngreso =queriesdao.crear_partido(strEquipoLocal, strEquipoVisitante, goles_local, goles_visitante, strFecha, equipo_local, equipo_visitante);
				
		}
		catch(Exception e) 
		{ 
			String msg=  "error "+e;
            System.out.println("error "+e);
		}
		
		if (bolIngreso) 
		{
			  
			  FacesContext.getCurrentInstance().addMessage(null, new
			  FacesMessage("Fue Ingresado el partido "));
			  
			  return "ver_partido"; 
		} 
		else if(!strMensajeError.equals(""))
		{
			FacesContext.getCurrentInstance().addMessage( null, new
					  FacesMessage(FacesMessage.SEVERITY_WARN,
							  strMensajeError,
							  strMensajeError));
					  
			return "ver_partido"; 
		}
		else {
			  
			  FacesContext.getCurrentInstance().addMessage( null, new
			  FacesMessage(FacesMessage.SEVERITY_WARN,
			  "ERROR INTERNO APLICACION - COMUNICAR ADMINISTRADOR",
			  "ERROR INTERNO APLICACION - COMUNICAR ADMINISTRADOR"));
			  
			  return "ver_partido"; 
		}
		
		
		//return "gestionar";
	}
	
	public String modificarPartido() 
	{
		String strUsuario;
		String strIdCredito;
		String strMensajeError ="";
		
		boolean bolExistePlaca = false;
		partidoDAO queriesdao = new partidoDAO();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date datFechaNull =null;
		String strFechanull = "1900-01-01";
		try
		{
			datFechaNull = new SimpleDateFormat("yyyy-MM-dd").parse(strFechanull);	
		}
		catch(Exception e)
		{
			System.out.println("error en bean con fechas null"+e);
		}
		
		
		
        if(fecha==null)
        {
        	
        	strFecha = format.format(datFechaNull);
        	fecha = datFechaNull;
        }
        else
        {
        	strFecha = format.format(fecha);
        }
		
		System.out.println("strFecha"+strFecha);
		
		boolean bolIngreso= false;
		//QueriesDAO queriesdao = new QueriesDAO();
		try 
		{
				
				bolIngreso =queriesdao.modificar_partido(strEquipoLocal, strEquipoVisitante, goles_local, goles_visitante, strFecha, id, equipo_local, equipo_visitante);
				
		}
		catch(Exception e) 
		{ 
			String msg=  "error "+e;
            System.out.println("error "+e);
		}
		
		if (bolIngreso) 
		{
			  
			  FacesContext.getCurrentInstance().addMessage(null, new
			  FacesMessage("Fue Ingresado el partido "));
			  
			  return "ver_partido"; 
		} 
		else if(!strMensajeError.equals(""))
		{
			FacesContext.getCurrentInstance().addMessage( null, new
					  FacesMessage(FacesMessage.SEVERITY_WARN,
							  strMensajeError,
							  strMensajeError));
					  
			return "modificar_partido"; 
		}
		else {
			  
			  FacesContext.getCurrentInstance().addMessage( null, new
			  FacesMessage(FacesMessage.SEVERITY_WARN,
			  "ERROR INTERNO APLICACION - COMUNICAR ADMINISTRADOR",
			  "ERROR INTERNO APLICACION - COMUNICAR ADMINISTRADOR"));
			  
			  return "modificar_partido"; 
		}
		
		
		//return "gestionar";
	}
	
	
	
	//public List<ays_ges_detalle_tarea> getTareas()
		public List getPartidos()
		{
			FacesContext context = FacesContext.getCurrentInstance();
			partidoDAO queriesdao = new partidoDAO();
			
			//List<Vehiculo> listaVehiculos2 = new ArrayList();
			//List<ays_ges_detalle_tarea> listaTareas = new ArrayList<>();
			List listaVehiculos = new ArrayList<>();
			try 
			{
				listaVehiculos = queriesdao.getPartidos();
				
			}
			catch (Exception e) {
				
				e.printStackTrace();
			} 
			
			return listaVehiculos;
		}
	
		public String validatePartido(ArrayList parPartido) 
		{
			
			//tra_tercero veh = new tra_tercero();
			//veh =parVehiculo;
			try
			{
				
				strEquipoLocal = (String) parPartido.get(0);
				strEquipoVisitante = (String) parPartido.get(2);
				String tmp =(String) parPartido.get(1);
				String tmp2 =(String) parPartido.get(3);
				String tmp3 =(String) parPartido.get(5);
				if(!tmp3.equals(""))
				{
					id = Integer.parseInt(tmp3);
				}
				if(!tmp.equals(""))
				{
					goles_local = Integer.parseInt(tmp);
				}
				if(!tmp2.equals(""))
				{
					goles_visitante = Integer.parseInt(tmp2);
				}

				
				String tmp6 = (String) parPartido.get(4);
				fecha =new SimpleDateFormat("yyyy-MM-dd").parse(tmp6);  


				
				return "modificar_partido";
			}
			catch(Exception e)
			{
				
				System.out.println("OJO error"+e);
				return "nuevo_partido";
			}
		}
		
		
		
	public ArrayList getEquipos()
	{
		partidoDAO queriesdao = new partidoDAO();
		
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

	
	public List getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	
	public  Map<String, Object> getEquiposValue() {
		return EquiposValue;
	}

	public void setTipoDocumentoValue(Map<String, Object> EquiposValue) {
		EquiposValue = EquiposValue;
	}
	
	
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
	
	
	
	public String getStrFecha() {
		return strFecha;
	}

	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}

	
	
	public String getStrEquipoLocal() {
		return strEquipoLocal;
	}

	public void setStrEquipoLocal(String strEquipoLocal) {
		this.strEquipoLocal = strEquipoLocal;
	}

	public String getStrEquipoVisitante() {
		return strEquipoVisitante;
	}

	public void setStrEquipoVisitante(String strEquipoVisitante) {
		this.strEquipoVisitante = strEquipoVisitante;
	}

	@Override
	public String toString() {
		return "partidoBean [id=" + id + ", fecha=" + fecha + ", equipo_local=" + equipo_local + ", equipo_visitante="
				+ equipo_visitante + ", goles_local=" + goles_local + ", goles_visitante=" + goles_visitante + "]";
	}
	
	
	
}
