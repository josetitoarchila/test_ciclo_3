package com.jta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.jta.model.PlantillaController;
import com.jta.model.*;

public class equipoDAO {

	static conexion con = null;
	
	/**
	 * A Class class.
	 * ..............................................................................
	 * 
	 * @fecha_de_creacin : 18/06/2021
	 *                   ...............................................................................
	 * @method : crear_equipo ()
	 *         ...............................................................................
	 * @author AUTOR: Jose Tito Archila A
	 *         ...............................................................................
	 * @Proposito : metodo que ingresa en la tabla equipo
	 *            ..............................................................................
	 * @Consideraciones : S
	 * @webmethod
	 * 

	 * 
	 */
	public static boolean crear_equipo(String parNombre, String parNombreEntrenador)
			throws SQLException, ClassNotFoundException {

		Connection conDb = null;
		PreparedStatement prdStmt = null;
		String strError = "SI";
		boolean bolExito = true;
		int numId = 0;
		try {
			String strFechaGestion = obtenerFecha();
			String strFechaGestion2 = obtenerFecha2();
		String strStm = null;
		
		numId = getIdMaximoNumeroEquipo();

		
		Date datFechagestion = null;
		String strFechagestion = "1900-01-01";
		
    	datFechagestion = new SimpleDateFormat("yyyy-MM-dd").parse(strFechaGestion2);
    	java.sql.Date datefechagestion = new java.sql.Date(datFechagestion.getTime());

		
		//String strUnico = parNit + " " + parCredito + " " + parCodemp + " " + parCodGestor + " " + parIndicador + " " + strFechaGestion;
		// PreparedStatement prdStmt;
		// String str_fecha_actual = obtenerFecha();
		if (conDb == null)
			conDb = con.obtener();
		// traer el consecutivo del cliente



		
			strStm = "   Insert into bd_campeonato.equipo   "
				+ " ( id, nombre, nombre_entrenador) " + " Values "
				+ " ( ?, ?, ?) ";
		
			prdStmt = conDb.prepareStatement(strStm);
			prdStmt.setInt(1, numId);
			prdStmt.setString(2, parNombre);
			
			prdStmt.setString(3, parNombreEntrenador);
			
			bolExito = prdStmt.execute();
		} catch (Exception  se) {
			strError = "NO";
			System.out.println("error en Bean crear equipo" + se);
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
	
	/**
	 * A Class class.
	 * ..............................................................................
	 * 
	 * @fecha_de_creacin : 18/06/2021
	 *                   ...............................................................................
	 * @method : actualizar equipo ()
	 *         ...............................................................................
	 * @author AUTOR: Jose Tito Archila A
	 *         ...............................................................................
	 * @Proposito : metodo que modifica en la tabla equipo
	 *            ..............................................................................
	 * @Consideraciones : S
	 * @webmethod
	 * 

	 * 
	 */
	
	public static boolean modificar_equipo(String parNombre, String parNombreEntrenador, int parId)
			throws SQLException, ClassNotFoundException {

		Connection conDb = null;
		PreparedStatement prdStmt = null;
		String strError = "SI";
		boolean bolExito = true;
		int numId = 0;
		try {
			String strFechaGestion = obtenerFecha();
			String strFechaGestion2 = obtenerFecha2();
		String strStm = null;
		
		PlantillaController pc = new PlantillaController();	
		String strNombreLogueado = pc.getNombreLogueado();
		
		Date datFechagestion = null;
		String strFechagestion = "1900-01-01";
		
    	datFechagestion = new SimpleDateFormat("yyyy-MM-dd").parse(strFechaGestion2);
    	java.sql.Date datefechagestion = new java.sql.Date(datFechagestion.getTime());
    	
    	
		
		if (conDb == null)
			conDb = con.obtener();
		
			strStm = "   	update   	bd_campeonato.equipo  "
				+ "  		set 		nombre=?,	"
				+ "						nombre_entrenador=?	"
				+ "			where 		id=? 	 ";
		
			prdStmt = conDb.prepareStatement(strStm);
			
			prdStmt.setString(1, parNombre);
			
			prdStmt.setString(2, parNombreEntrenador);
			
			prdStmt.setInt(3, parId);
			
			
			bolExito = prdStmt.execute();
		} catch (Exception  se) {
			strError = "NO";
			System.out.println("error en DAO modificar producto " + se);
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
	
	/**
	 * A Class class.
	 * ..............................................................................
	 * 
	 * @fecha_de_creacin : 18/06/2021
	 *                   ...............................................................................
	 * @method : actualizar equipo ()
	 *         ...............................................................................
	 * @author AUTOR: Jose Tito Archila A
	 *         ...............................................................................
	 * @Proposito : metodo que modifica en la tabla equipo
	 *            ..............................................................................
	 * @Consideraciones : S
	 * @webmethod
	 * 

	 * 
	 */
	
	public static boolean elliminar_equipo(int parId)
			throws SQLException, ClassNotFoundException {

		Connection conDb = null;
		PreparedStatement prdStmt = null;
		String strError = "SI";
		boolean bolExito = true;
		int numId = 0;
		try {
			String strFechaGestion = obtenerFecha();
			String strFechaGestion2 = obtenerFecha2();
		String strStm = null;
		
		PlantillaController pc = new PlantillaController();	
		String strNombreLogueado = pc.getNombreLogueado();
		
		Date datFechagestion = null;
		String strFechagestion = "1900-01-01";
		
    	datFechagestion = new SimpleDateFormat("yyyy-MM-dd").parse(strFechaGestion2);
    	java.sql.Date datefechagestion = new java.sql.Date(datFechagestion.getTime());
    	
    	
		
		if (conDb == null)
			conDb = con.obtener();
		
			strStm = "   	delete from    	bd_campeonato.equipo 	"
				+ "			where 		id=? 	 ";
		
			prdStmt = conDb.prepareStatement(strStm);
			
			prdStmt.setInt(1, parId);
			
			
			bolExito = prdStmt.execute();
		} catch (Exception  se) {
			strError = "NO";
			System.out.println("error en DAO eliminar equipo " + se);
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
	
	
	/**
	 * A Class class.
	 * ..............................................................................
	 * 
	 * @fecha_de_creacin : 18/06/2021
	 *                   ...............................................................................
	 * @method : actualizar equipo ()
	 *         ...............................................................................
	 * @author AUTOR: Jose Tito Archila A
	 *         ...............................................................................
	 * @Proposito : metodo que modifica en la tabla equipo
	 *            ..............................................................................
	 * @Consideraciones : S
	 * @webmethod
	 * 

	 * 
	 */
	
	public static boolean eliminar_equipo( int parId)
			throws SQLException, ClassNotFoundException {

		Connection conDb = null;
		PreparedStatement prdStmt = null;
		String strError = "SI";
		boolean bolExito = true;
		int numId = 0;
		try {
			String strFechaGestion = obtenerFecha();
			String strFechaGestion2 = obtenerFecha2();
		String strStm = null;
		
		PlantillaController pc = new PlantillaController();	
		String strNombreLogueado = pc.getNombreLogueado();
		
		Date datFechagestion = null;
		String strFechagestion = "1900-01-01";
		
    	datFechagestion = new SimpleDateFormat("yyyy-MM-dd").parse(strFechaGestion2);
    	java.sql.Date datefechagestion = new java.sql.Date(datFechagestion.getTime());
    	
    	
		
		if (conDb == null)
			conDb = con.obtener();
		
			strStm = "   	delete from   	bd_campeonato.equipo  "
				+ " 		where 		id=? 	 ";
		
			prdStmt = conDb.prepareStatement(strStm);
			
			prdStmt.setInt(1, parId);
			
			
			bolExito = prdStmt.execute();
		} catch (Exception  se) {
			strError = "NO";
			System.out.println("error en DAO modificar producto " + se);
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
	 * @Consideraciones : 
	 *****************************************************************************/
	
	
	
	public static int getIdMaximoNumeroEquipo()
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
			//strStm = "   SELECT 		id_tarea "
					+ "   FROM 		bd_campeonato.equipo ";

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
				
				 strPrimerNombre = rstEmpresa.getString(1);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
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
		if(intConsecutivoTarea==0)
		{
			intConsecutivoTarea =1;
		}
		
		return intConsecutivoTarea;
	} // Fin consGestorxCodigo2()
	
	public static String obtenerFecha()
    {
        java.util.Calendar fecha = java.util.Calendar.getInstance();
        String  strFecha    = "";
        String  strMes      = "";
        String  strDia      = "";
        String  strHora     = "";
        String  strMinutos     = "";
        String  strSegundos     = "";
        String  strAmpm     = "AM";
      //strFecha = fecha.get(Calendar.DATE) + "" + fecha.get(java.util.Calendar.MONTH) + "" + fecha.get(java.util.Calendar.YEAR)+""+fecha.get(Calendar.HOUR)+""+fecha.get(Calendar.SECOND);        
       //strFecha = fecha.get(Calendar.DATE) + "" + fecha.get(java.util.Calendar.MONTH) + "" + fecha.get(java.util.Calendar.YEAR)+""+fecha.get(Calendar.SECOND);
        int intMes = fecha.get(java.util.Calendar.MONTH)+1;
        int intDia = fecha.get(java.util.Calendar.DATE);        
        int intHora = fecha.get(Calendar.HOUR);
        int intMinutos = fecha.get(Calendar.MINUTE);
        int intSegundos = fecha.get(Calendar.SECOND);
        int intAmpm     = fecha.get(Calendar.AM_PM);
        if(intMes<10)
        {
            strMes = "0"+intMes;
        }
        else
        {
            strMes =  Integer.toString(intMes);
        }
        if(intDia<10)
        {
            strDia = "0"+intDia;
        }
        else
        {
            strDia =  Integer.toString(intDia);
        }
        //HORA
        if(intHora<10)
        {
            strHora = "0"+intHora;
        }
        else
        {
            strHora =  Integer.toString(intHora);
        }
        //MINUTOS
        if(intMinutos<10)
        {
            strMinutos = "0"+intMinutos;
        }
        else
        {
            strMinutos =  Integer.toString(intMinutos);
        }
        //SEGUNGOS
        if(intSegundos<10)
        {
            strSegundos = "0"+intSegundos;
        }
        else
        {
            strSegundos =  Integer.toString(intSegundos);
        }
        if(intAmpm==1) {
            
            strAmpm ="PM";
        }
        //strAmpm = Integer.toString(intAmpm);
        //strFecha = fecha.get(Calendar.YEAR) + "/" + fecha.get(java.util.Calendar.MONTH) + "/" + fecha.get(java.util.Calendar.DATE);
        strFecha = fecha.get(Calendar.YEAR) + "/" + strMes + "/" + strDia +" " + strHora + ":" + strMinutos +":"+strSegundos + " " + strAmpm;
        return strFecha;
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
	 * @Consideraciones : 
	 *****************************************************************************/
	
    public static ArrayList getEquipo()
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
	
		    strStm = 	"	   	SELECT id, nombre, nombre_entrenador " + 
	    				"   	FROM 		bd_campeonato.equipo  order by nombre  ";
		    
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
	 * @Consideraciones : 
	 *****************************************************************************/
	
    public static ArrayList getEquipoxId(int parIdModificar)
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
	
		    strStm = 	"	   	SELECT id, nombre, nombre_entrenador " + 
	    				"   	FROM 		bd_campeonato.equipo where id=?  order by nombre  ";
		    
		    prdStmt = conDb.prepareStatement(strStm);
		    
		    prdStmt.setInt(1, parIdModificar);
		    
		    
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
    
	
	public static String obtenerFecha2()
    {
        java.util.Calendar fecha = java.util.Calendar.getInstance();
        String  strFecha    = "";
        String  strMes      = "";
        String  strDia      = "";
        String  strHora     = "";
        String  strMinutos     = "";
        String  strSegundos     = "";
        String  strAmpm     = "AM";
      //strFecha = fecha.get(Calendar.DATE) + "" + fecha.get(java.util.Calendar.MONTH) + "" + fecha.get(java.util.Calendar.YEAR)+""+fecha.get(Calendar.HOUR)+""+fecha.get(Calendar.SECOND);        
       //strFecha = fecha.get(Calendar.DATE) + "" + fecha.get(java.util.Calendar.MONTH) + "" + fecha.get(java.util.Calendar.YEAR)+""+fecha.get(Calendar.SECOND);
        int intMes = fecha.get(java.util.Calendar.MONTH)+1;
        int intDia = fecha.get(java.util.Calendar.DATE);        
        int intHora = fecha.get(Calendar.HOUR);
        int intMinutos = fecha.get(Calendar.MINUTE);
        int intSegundos = fecha.get(Calendar.SECOND);
        int intAmpm     = fecha.get(Calendar.AM_PM);
        if(intMes<10)
        {
            strMes = "0"+intMes;
        }
        else
        {
            strMes =  Integer.toString(intMes);
        }
        if(intDia<10)
        {
            strDia = "0"+intDia;
        }
        else
        {
            strDia =  Integer.toString(intDia);
        }
        //HORA
        if(intHora<10)
        {
            strHora = "0"+intHora;
        }
        else
        {
            strHora =  Integer.toString(intHora);
        }
        //MINUTOS
        if(intMinutos<10)
        {
            strMinutos = "0"+intMinutos;
        }
        else
        {
            strMinutos =  Integer.toString(intMinutos);
        }
        //SEGUNGOS
        if(intSegundos<10)
        {
            strSegundos = "0"+intSegundos;
        }
        else
        {
            strSegundos =  Integer.toString(intSegundos);
        }
        if(intAmpm==1) {
            
            strAmpm ="PM";
        }
        //strAmpm = Integer.toString(intAmpm);
        //strFecha = fecha.get(Calendar.YEAR) + "/" + fecha.get(java.util.Calendar.MONTH) + "/" + fecha.get(java.util.Calendar.DATE);
        //strFecha = fecha.get(Calendar.YEAR) + "/" + strMes + "/" + strDia +" " + strHora + ":" + strMinutos +":"+strSegundos + " " + strAmpm;
        strFecha = fecha.get(Calendar.YEAR) + "-" + strMes + "-" + strDia;
        return strFecha;
    }
	
	
}
