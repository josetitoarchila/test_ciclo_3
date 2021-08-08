package com.jta.model;


public class adm_menu 
{
	private int id_menu;
	private String nombre;
	private String tipo;
	private String perfil_usuario;
	private String codigo_submenu;
	private adm_menu submenu;
	/*@Column(name="codigo_submenu")
	private String codigo_submenu;*/

	private String estado;
	
	private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPerfil_usuario() {
		return perfil_usuario;
	}
	public void setPerfil_usuario(String perfil_usuario) {
		this.perfil_usuario = perfil_usuario;
	}

	public adm_menu getSubmenu() {
		return submenu;
	}
	public void setSubmenu(adm_menu submenu) {
		this.submenu = submenu;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public String getCodigo_submenu() {
		return codigo_submenu;
	}
	public void setCodigo_submenu(String codigo_submenu) {
		this.codigo_submenu = codigo_submenu;
	}
	@Override
	public String toString() {
		return "jta_adm_menu [id_menu=" + id_menu + ", nombre=" + nombre + ", tipo=" + tipo + ", perfil_usuario="
				+ perfil_usuario + ", codigo_submenu=" + submenu + ", estado=" + estado + ", url=" + url + "]";
	}
}