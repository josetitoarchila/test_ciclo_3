package com.jta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jta.model.conexion;
import com.jta.model.adm_usuario;

public class adm_usuarioDAO {
	
static conexion con = null;
	
	
	
	
	/*****************************************************************************
     * @Nombre del m�todo : consGestorxCodigo2
     *         .............................................................................. 
     *         @fecha_de_creaci�n
     *         : 09/05/2008
     *         ..............................................................................
     *         <P>
     * @author AUTOR: Jos� Tito Archila Angarita
     *         ..............................................................................
     * @Proposito : Trae el nombre del usuario asignado de la tabla ADM_CONT_INT
     *            ..............................................................................
     * @Entradas :
     *           ..............................................................................
     * @Salidas :
     *          ..............................................................................
     * @Consideraciones : Software basado de aplicativo www.navesoft.com:
     *****************************************************************************/
    public static String getUsuario(adm_usuario usuario)
	    throws SQLException, ClassNotFoundException 
    {
		Connection conDb = null;
		String strStm = null;
		String strCodGestor = "";
		String strNomGestor = "";
		String strCorGestor = "";
		ResultSet rstEmpresa = null;
		ArrayList arListEmpresa = new ArrayList();
		int intTamFilas = 0;
		int intCodTarea = 0;
	
		String[] strArrColumnas = null;
		int intTamColumnas = 0;
		PreparedStatement prdStmt = null;
		
		String strUsuario = "";
		String strClave = "";
		strUsuario = usuario.getId_usuario();
		strClave = usuario.getContraseña();
		
		try {
	
		    if (conDb == null)
			conDb = conexion.obtener();
	
		    
		    strStm = 	"	   	SELECT   CONCAT(rtrim(primer_nombre) , ' ' , rtrim(primer_apellido)) as nombres  " + 
	    				"   	FROM 		bd_campeonato.adm_usuario "
	    			+ 	"		where  id_usuario =? and contraseña=? ";
		    
		    prdStmt = conDb.prepareStatement(strStm);
		    
		    prdStmt.setString (1, strUsuario);
		    prdStmt.setString (2, strClave);
		    
		    rstEmpresa = prdStmt.executeQuery();
		    ResultSetMetaData rsMetaData = rstEmpresa.getMetaData();
		    intTamColumnas = rsMetaData.getColumnCount();
		    strArrColumnas = new String[intTamColumnas];
		    for (int i = 0; i < intTamColumnas; i++) {
			strArrColumnas[i] = rsMetaData.getColumnName(i + 1);
		    }
		    while (rstEmpresa.next()) {
			ArrayList arrListFila = new ArrayList(intTamColumnas);
			for (int i = 1; i <= intTamColumnas; i++) {
			    //arrListFila.add(new String((rstEmpresa.getString(i) == null) ? "" : (rstEmpresa.getString(i))));
				strCorGestor = rstEmpresa.getString(1);
			    // arrListFila.add( new String(rstEmpresa.getString(i)));
			}
			arListEmpresa.add(arrListFila);
			intTamFilas++;
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if (prdStmt != null)
			prdStmt.close();
		    if (conDb != null)
			conDb.close();
		    if (rstEmpresa != null)
			rstEmpresa.close();
		}
	
		return strCorGestor;
    } // Fin consGestorxCodigo2()
    
    /*****************************************************************************
     * @Nombre del m�todo : consGestorxCodigo2
     *         .............................................................................. 
     *         @fecha_de_creaci�n
     *         : 09/05/2008
     *         ..............................................................................
     *         <P>
     * @author AUTOR: Jos� Tito Archila Angarita
     *         ..............................................................................
     * @Proposito : Trae el nombre del usuario asignado de la tabla ADM_CONT_INT
     *            ..............................................................................
     * @Entradas :
     *           ..............................................................................
     * @Salidas :
     *          ..............................................................................
     * @Consideraciones : Software basado de aplicativo www.navesoft.com:
     *****************************************************************************/
    public static adm_usuario getUsuario2(adm_usuario usuario)
	    throws SQLException, ClassNotFoundException 
    {
		Connection conDb = null;
		String strStm = null;
		String strCodGestor = "";
		String strNomGestor = "";
		String strCorGestor = "";
		ResultSet rstEmpresa = null;
		ArrayList arListEmpresa = new ArrayList();
		int intTamFilas = 0;
		int intCodTarea = 0;
	
		String[] strArrColumnas = null;
		int intTamColumnas = 0;
		PreparedStatement prdStmt = null;
		
		String strUsuario = "";
		String strClave = "";
		strUsuario = usuario.getId_usuario();
		strClave = usuario.getContraseña();
		
		adm_usuario usuario2 = new adm_usuario();
		
		try {
	
		    if (conDb == null)
			conDb = conexion.obtener();
	
		    
		    strStm = 	"	   	SELECT   	rtrim(id_usuario), rtrim(id_tipo_documento), numero_documento, rtrim(primer_nombre), "
		    			+ "					rtrim(segundo_nombre), rtrim(primer_apellido), rtrim(segundo_apellido), rtrim(correo_electronico),	"
		    			+ "   				rtrim(activo), id, perfil, contraseña	" + 
	    				"   	FROM 		bd_campeonato.adm_usuario "
	    				+ 	"		where  id_usuario =? and contraseña=? ";
		    
		    prdStmt = conDb.prepareStatement(strStm);
		    
		    prdStmt.setString (1, strUsuario);
		    prdStmt.setString (2, strClave);
		    
		    rstEmpresa = prdStmt.executeQuery();
		    ResultSetMetaData rsMetaData = rstEmpresa.getMetaData();
		    intTamColumnas = rsMetaData.getColumnCount();
		    strArrColumnas = new String[intTamColumnas];
		    for (int i = 0; i < intTamColumnas; i++) {
			strArrColumnas[i] = rsMetaData.getColumnName(i + 1);
		    }
		    while (rstEmpresa.next()) {
			ArrayList arrListFila = new ArrayList(intTamColumnas);
			for (int i = 1; i <= intTamColumnas; i++) {
			    //arrListFila.add(new String((rstEmpresa.getString(i) == null) ? "" : (rstEmpresa.getString(i))));
				//strCorGestor = rstEmpresa.getString(1);
				
				usuario2.setId_usuario(rstEmpresa.getString(1));

				usuario2.setId_tipo_documento(rstEmpresa.getString(2));
				usuario2.setNumero_documento(rstEmpresa.getString(3));
				usuario2.setPrimer_nombre(rstEmpresa.getString(4));
				usuario2.setSegundo_nombre(rstEmpresa.getString(5));
				usuario2.setPrimer_apellido(rstEmpresa.getString(6));
				usuario2.setSegundo_apellido(rstEmpresa.getString(7));
				usuario2.setCorreo_electronico(rstEmpresa.getString(8));
				usuario2.setActivo(rstEmpresa.getString(9));
				usuario2.setPerfil(rstEmpresa.getString(11));
				

				
			    // arrListFila.add( new String(rstEmpresa.getString(i)));
			}
			arListEmpresa.add(arrListFila);
			intTamFilas++;
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if (prdStmt != null)
			prdStmt.close();
		    if (conDb != null)
			conDb.close();
		    if (rstEmpresa != null)
			rstEmpresa.close();
		}
	
		return usuario2;
    } // Fin consGestorxCodigo2()
    
    
    
    /**
	 * A Class class.
	 * ..............................................................................
	 * 
	 * @fecha_de_creacin : 05/06/2008
	 *                   ...............................................................................
	 * @method : crear_cliente ()
	 *         ...............................................................................
	 * @author AUTOR: Jose Tito Archila A
	 *         ...............................................................................
	 * @fecha_de_creacin : 05/06/2008
	 *                   ...............................................................................
	 * @Proposito : metodo que ingresa en la tabla jur_clientes
	 *            ..............................................................................
	 * @Consideraciones : Software basado de aplicativo www.navesoft.com:
	 * @webmethod
	 * 
	 *          				bolIngreso =queriesdao.crear_usuario(id_usuario, numero_documento, id_tipo_documento, primer_nombre.toUpperCase(), segundo_nombre.toUpperCase(), 
											primer_apellido.toUpperCase(), segundo_apellido.toUpperCase(), correo_electronico, perfil, clave);

	 * 
	 */
	public static boolean crear_usuario(String parUsuario, String parPrimerNombre, String parSegundoNombre, 
			String parPrimerApellido, String parSegundoApellido, String parCorreoElectronico, String parClave)
			throws SQLException, ClassNotFoundException {

		Connection conDb = null;
		PreparedStatement prdStmt = null;
		String strError = "SI";
		boolean bolExito = true;
		int numId = 0;
		try {
			String strStm = null;
			numId = getIdMaximoNumeroUsuario();
	
			if (conDb == null)
				conDb = con.obtener();


			 String numDocumento= String.valueOf(numId);
		
			strStm = "   Insert into  bd_campeonato.adm_usuario   "
				+ " ( id, id_usuario, numero_documento, id_tipo_documento, primer_nombre,  "
				+ "   segundo_nombre, primer_apellido, segundo_apellido, correo_electronico, activo,  "
				+ "   perfil, contraseña) " + " Values "
				+ " ( ?, ?, ?, ?, ?, " + "   ?, ?, ?, ?, ?, " + "   ?, ?) ";
		
			prdStmt = conDb.prepareStatement(strStm);
			
			prdStmt.setInt(1, numId);
			prdStmt.setString(2, parUsuario);
			prdStmt.setString(3, numDocumento);
			prdStmt.setString(4, "CC");
			prdStmt.setString(5, parPrimerNombre);
			prdStmt.setString(6, parSegundoNombre);
			prdStmt.setString(7, parPrimerApellido);
			prdStmt.setString(8, parSegundoApellido);
			prdStmt.setString(9, parCorreoElectronico);
			prdStmt.setString(10, "S");
			prdStmt.setString(11, "");
			prdStmt.setString(12, parClave);
			
			bolExito = prdStmt.execute();
		} catch (Exception  se) {
			strError = "NO";
			System.out.println("error en Bean crear gestion" + se);
			// log the exception
			bolExito = false;

			// re-throw the exception

		} finally {

			prdStmt.close();
			conDb.close();
		}

		if (strError.equals("SI")) {

			bolExito = true;
		} else {

			bolExito = false;
		}
		return bolExito;
	}
    
    
	/*****************************************************************************
	 * @Nombre del m�todo : consGestorxCodigo2
	 *         .............................................................................. @fecha_de_creaci�n
	 *         : 09/05/2008
	 *         ..............................................................................
	 *         <P>
	 * @author AUTOR: Jos� Tito Archila Angarita
	 *         ..............................................................................
	 * @Proposito : Trae el nombre del usuario asignado de la tabla ADM_CONT_INT
	 *            ..............................................................................
	 * @Entradas :
	 *           ..............................................................................
	 * @Salidas :
	 *          ..............................................................................
	 * @Consideraciones : Software basado de aplicativo www.navesoft.com:
	 *****************************************************************************/
	public static int getIdMaximoNumeroUsuario()
			throws SQLException, ClassNotFoundException 
	{
		Connection conDb = null;
		String strStm = null;
		String strCodGestor = "";
		String strNombre = "";
		String strCorGestor = "";
		String strPrimerNombre = "";
		String strPrimerApellido = "";
		ResultSet rstEmpresa = null;
		int intConsecutivoTarea =0;
		String[] strArrColumnas = null;
		int intTamColumnas = 0;
		// int intTamFilas = 0;
		PreparedStatement prdStmt = null;
		try {
			if (conDb == null)
				conDb = con.obtener();

			strStm = "   SELECT 		max(id)+1 "
					+ "   FROM 		bd_campeonato.adm_usuario ";

			prdStmt = conDb.prepareStatement(strStm);

			rstEmpresa = prdStmt.executeQuery();
			ResultSetMetaData rsMetaData = rstEmpresa.getMetaData();
			intTamColumnas = rsMetaData.getColumnCount();
			strArrColumnas = new String[intTamColumnas];
			for (int i = 0; i < intTamColumnas; i++) {
				strArrColumnas[i] = rsMetaData.getColumnName(i + 1);
			}
			while (rstEmpresa.next()) {
				intConsecutivoTarea = Integer.parseInt(rstEmpresa.getString(1));
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("ERROR "+e);
		} finally {
			if (prdStmt != null)
				prdStmt.close();
			if (conDb != null)
				conDb.close();
			if (rstEmpresa != null)
				rstEmpresa.close();
		}
		/*
		 * prdStmt.close(); conDb.close();
		 */
		return intConsecutivoTarea;
	} // Fin consGestorxCodigo2()

	/*****************************************************************************
     * @Nombre del m�todo : consGestorxCodigo2
     *         .............................................................................. 
     *         @fecha_de_creaci�n
     *         : 09/05/2008
     *         ..............................................................................
     *         <P>
     * @author AUTOR: Jos� Tito Archila Angarita
     *         ..............................................................................
     * @Proposito : Trae el nombre del usuario asignado de la tabla ADM_CONT_INT
     *            ..............................................................................
     * @Entradas :
     *           ..............................................................................
     * @Salidas :
     *          ..............................................................................
     * @Consideraciones : Software basado de aplicativo www.navesoft.com:
     *****************************************************************************/
    public static ArrayList getUsuario()
	    throws SQLException, ClassNotFoundException 
    {
		Connection conDb = null;
		String strStm = null;
		String strCodGestor = "";
		String strNomGestor = "";
		String strCorGestor = "";
		ResultSet rstEmpresa = null;
		ArrayList arListEmpresa = new ArrayList();
		int intTamFilas = 0;
	
		String[] strArrColumnas = null;
		int intTamColumnas = 0;
		// int intTamFilas = 0;
		PreparedStatement prdStmt = null;
		try {
	
		    if (conDb == null)
			conDb = conexion.obtener();
	
		    strStm = 	"	   	SELECT   id_usuario, rtrim(primer_nombre), rtrim(primer_apellido), rtrim(correo_electronico)	" + 
	    				"   	FROM 		bd_campeonato.adm_usuario order by id_usuario ";
		    
		    prdStmt = conDb.prepareStatement(strStm);
		    
		    rstEmpresa = prdStmt.executeQuery();
		    ResultSetMetaData rsMetaData = rstEmpresa.getMetaData();
		    intTamColumnas = rsMetaData.getColumnCount();
		    strArrColumnas = new String[intTamColumnas];
		    for (int i = 0; i < intTamColumnas; i++) {
			strArrColumnas[i] = rsMetaData.getColumnName(i + 1);
		    }
		    while (rstEmpresa.next()) {
			ArrayList arrListFila = new ArrayList(intTamColumnas);
			for (int i = 1; i <= intTamColumnas; i++) {
			    arrListFila.add(new String((rstEmpresa.getString(i) == null) ? "" : (rstEmpresa.getString(i))));
			    // arrListFila.add( new String(rstEmpresa.getString(i)));
			}
			arListEmpresa.add(arrListFila);
			intTamFilas++;
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if (prdStmt != null)
			prdStmt.close();
		    if (conDb != null)
			conDb.close();
		    if (rstEmpresa != null)
			rstEmpresa.close();
		}
		return arListEmpresa;
    } // Fin consGestorxCodigo2()
	

}
