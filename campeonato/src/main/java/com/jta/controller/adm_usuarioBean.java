package com.jta.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.jta.dao.adm_usuarioDAO;

import com.jta.model.adm_usuario;
import com.jta.model.SessionUtils;

@ManagedBean (name="adm_usuarioBean")
//@ViewScoped
@RequestScoped
//@SessionScoped


public class adm_usuarioBean implements Serializable
{
	
	//public ays_aut_usuario uservalidate2 = new ays_aut_usuario();
		adm_usuario objUsuario= new adm_usuario();
		public static final String HOME_PAGE_REDIRECT ="home.xhtml";
			  public static final String LOGOUT_PAGE_REDIRECT =
			      "/logout.xhtml?faces-redirect=true";
		
		private String name;
		private String password;
		private String userName;

		
		//private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
		
		public adm_usuarioBean() {}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		
		public String validateLoginCredentials() 
		{
			FacesContext context = FacesContext.getCurrentInstance(); 
			adm_usuario c1= new adm_usuario();
			
			System.out.println("userName"+userName);
			System.out.println("clave"+password);
			
			c1.setId_usuario(userName);
			c1.setContraseña(password);
			String validationResult = "index";
			adm_usuarioDAO usuariodao = new adm_usuarioDAO();
			
			List<adm_usuario> listaUsuarios = new ArrayList<>();
			
			//objUsuario = usuariodao.getUsuario(c1);
			
			String strValidateUser = "";
			
			

			try 
			{
				strValidateUser = usuariodao.getUsuario(c1);
				objUsuario = usuariodao.getUsuario2(c1);
				//if ((c2 != null) && (userName.equalsIgnoreCase(c2.getId_usuario()) && password.equals(c2.getContraseña()))) 
				//if ((objUsuario != null) && (userName.equalsIgnoreCase(objUsuario.getId_usuario()) && password.equals(objUsuario.getContraseña())))
				if(!strValidateUser.equals(""))
	            {
	            	validationResult ="editar";
	                //String msg=  "Bienvenido "+objUsuario.getPrimer_nombre()+ " "+objUsuario.getPrimer_apellido();
	            	String msg=  "Bienvenid@ "+strValidateUser;
	                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	                HttpSession session = SessionUtils.getSession();
	                session.setAttribute("username", objUsuario);
	                
	    			//LOGGER.info("LOGGER: login successful for '{}'", objUsuario.getId_usuario());
	    			
	            } 
	            else
	            {
	            	validationResult = "index";
	            	String msg=  "";
	            	if(userName == null)
	            	{
	            		msg=  "El campo unidad no debe estar vacio ";
	            	}
	            	else
	            	{
	            		msg=  "Convinacion usuario -contraseña no es valido "+userName;
	            	}
	                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	                
	            }
	        } catch(Exception exObj) {
	            validationResult = "index";
	            String msg=  "Convinacion usuario -contraseña no es valido "+userName;
	            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	        }
			if(validationResult.equals("editar"))
			{
				SessionUtils su = new SessionUtils();
				
			//	LOGGER.info("LOGGER: login es ", su.getUserId());
				return HOME_PAGE_REDIRECT;
			}
			else
			{
				return null;
			}
		}
		
		//logout event, invalidate session
		public String logout() 
		{
			String identifier = userName;
			//LOGGER.info("LOGGER-ANTES DE logout successful for '{}'", identifier);
		    //LOGGER.debug("invalidating session for '{}'", identifier);
		    FacesContext.getCurrentInstance().getExternalContext()
		        .invalidateSession();
		    objUsuario = null;

		    //LOGGER.info("LOGGER-logout successful for '{}'", identifier);
				return LOGOUT_PAGE_REDIRECT;
		}

		public boolean isLoggedIn() 
		{
			    return objUsuario != null;
		}

}