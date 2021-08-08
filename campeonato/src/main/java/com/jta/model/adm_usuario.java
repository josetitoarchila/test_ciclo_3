package com.jta.model;

import java.util.Date;

public class adm_usuario 
{

	private String id_usuario;
	
	 
	private String id_tipo_documento;
	private String numero_documento;
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String correo_electronico;
	private String activo;
	private String id_usuario_creacion;
	private Date fecha_creacion;
	private String ip_creacion;
	private String id_usuario_modificacion;
	private Date fecha_modificacion;
	private String ip_modificacion;
	private String perfil;
	private String contraseña;
	private String fecha_modificacion2;
	
	/*public String getId() {
	    return id;
	}*/
	
	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getId_tipo_documento() {
		return id_tipo_documento;
	}
	public void setId_tipo_documento(String id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}
	public String getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
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
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getId_usuario_creacion() {
		return id_usuario_creacion;
	}
	public void setId_usuario_creacion(String id_usuario_creacion) {
		this.id_usuario_creacion = id_usuario_creacion;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getIp_creacion() {
		return ip_creacion;
	}
	public void setIp_creacion(String ip_creacion) {
		this.ip_creacion = ip_creacion;
	}
	public String getId_usuario_modificacion() {
		return id_usuario_modificacion;
	}
	public void setId_usuario_modificacion(String id_usuario_modificacion) {
		this.id_usuario_modificacion = id_usuario_modificacion;
	}
	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public String getIp_modificacion() {
		return ip_modificacion;
	}
	public void setIp_modificacion(String ip_modificacion) {
		this.ip_modificacion = ip_modificacion;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getFecha_modificacion2() {
		return fecha_modificacion2;
	}
	public void setFecha_modificacion2(String fecha_modificacion2) {
		this.fecha_modificacion2 = fecha_modificacion2;
	}
	@Override
	public String toString() {
		return "adm_usuario [id_usuario=" + id_usuario + ", id_tipo_documento=" + id_tipo_documento
				+ ", numero_documento=" + numero_documento + ", primer_nombre=" + primer_nombre + ", segundo_nombre="
				+ segundo_nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido
				+ ", correo_electronico=" + correo_electronico + ", activo=" + activo + ", id_usuario_creacion="
				+ id_usuario_creacion + ", fecha_creacion=" + fecha_creacion + ", ip_creacion=" + ip_creacion
				+ ", id_usuario_modificacion=" + id_usuario_modificacion + ", fecha_modificacion=" + fecha_modificacion
				+ ", ip_modificacion=" + ip_modificacion + ", perfil=" + perfil + ", contraseña=" + contraseña
				+ ", fecha_modificacion2=" + fecha_modificacion2 + "]";
	}
	
	
	
}
