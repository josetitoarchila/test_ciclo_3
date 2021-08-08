
package com.jta.model;

import java.util.Enumeration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class PlantillaController 
{
	public void verificarSesion()
	{
		try
		{
			/*FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			Enumeration e = session.getAttributeNames();
			
			while (e.hasMoreElements())
			{
			  String attr = (String)e.nextElement();
			  System.err.println("      attr  = "+ attr);
			  Object value = session.getValue(attr);
			  System.err.println("      value = "+ value);
			}
			
			HttpSession session2 = SessionUtils.getSession();
			ays_aut_usuario us =(ays_aut_usuario)session2.getAttribute("username");
			
			//String test = session.getAttribute("username");
			System.out.println("Plantilla controler lo que trae ");*/
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			adm_usuario us =(adm_usuario)session.getAttribute("username");
			//ays_ges_unidades us2 =(ays_ges_unidades)session.getAttribute("unidad");
			
		}
		catch(Exception e)
		{
			System.out.println("Plantilla controler "+e);
		}
		
	}
	
	public String verificarSesionPermiso()
	{
		String strPermisos = "";
		try
		{
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			adm_usuario us =(adm_usuario)session.getAttribute("username");
			strPermisos = us.getPerfil();
		}
		catch(Exception e)
		{
			System.out.println("Plantilla controler "+e);
		}
		return strPermisos;
	}

	public String getNombreLogueado()
	{
		String strNombrePermisos = "";
		try
		{
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			adm_usuario us =(adm_usuario)session.getAttribute("username");
			strNombrePermisos = us.getPrimer_nombre() + " " + us.getPrimer_apellido();
		}
		catch(Exception e)
		{
			System.out.println("Plantilla controler "+e);
		}
		return strNombrePermisos;
	}

	
	
	
	
	public String getNombreLogueado2()
	{
		String strNombrePermisos = "";
		try
		{
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			adm_usuario us =(adm_usuario)session.getAttribute("username");
			strNombrePermisos = us.getId_usuario();
		}
		catch(Exception e)
		{
			System.out.println("Plantilla controler "+e);
		}
		return strNombrePermisos;
	}
	
	
	public String getPerfilLogueado()
	{
		String strNombrePermisos = "";
		try
		{
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			adm_usuario us =(adm_usuario)session.getAttribute("username");
			strNombrePermisos = us.getPerfil();
		}
		catch(Exception e)
		{
			System.out.println("Plantilla controler "+e);
		}
		return strNombrePermisos;
	}
	

	
	public String getUsuarioLogueado()
	{
		String strUsuarioLogueado = "";
		try
		{
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			adm_usuario us =(adm_usuario)session.getAttribute("username");
			strUsuarioLogueado = us.getId_usuario();
			System.out.println("strUsuarioLogueado en PC" +strUsuarioLogueado);

		}
		catch(Exception e)
		{
			System.out.println("Plantilla controler error "+e);
		}
		return strUsuarioLogueado;
	}
	
	public String getIdUsuarioLogueado()
	{
		String strUsuarioLogueado = "";
		try
		{
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			adm_usuario us =(adm_usuario)session.getAttribute("username");
			strUsuarioLogueado = us.getNumero_documento();
		}
		catch(Exception e)
		{
			System.out.println("Plantilla controler "+e);
		}
		return strUsuarioLogueado;
	}
	
	
	
}
