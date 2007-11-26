package scr.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public abstract class JdbcManager {
	protected Properties props = null;
	/** Metodo privado para pedir una conexion a la base de datos
	 * puede capturar dos tipos de excepciones, una es la ClassNotFoundException
	 * que es lanzada sin el metodo forName() recibe como parametro una clase que
	 * no existe, la otra es por algun problema en recuperar una conexion a la base
	 * de datos
	 * @throws ClassNotFoundException 
	 * @throws SQLException */
	private Connection getDB2Connection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		String db2Url = "jdbc:db2://ibm10:50001/sabd";
		String db2User = "db2admin";
		String db2Pass = "sabd03";
		String driverClassName ="com.ibm.db2.jcc.DB2Driver" ; 
		Class.forName(driverClassName) ;
		con = DriverManager.getConnection(db2Url,db2User,db2Pass);
	    return con;
	}

	private Connection getIDSConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		String dbUrl = "jdbc:informix-sqli://192.168.2.2:1525/grupo01:informixServer=Centauro"; 
		String dbUser = "sa505105";
		String dbPass = "sabd03";
		String driverClassName ="com.informix.jdbc.IfxDriver" ; 
		Class.forName(driverClassName) ;
		con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
	    return con;
	}
	
	protected Connection getDB2ConnectionFromProperties()throws ClassNotFoundException, SQLException {
		try {
			Properties props = this.getProperties();
			Connection con = null;
			String db2Url = props.getProperty("db2Url");
			String db2User = props.getProperty("db2User");
			String db2Pass = props.getProperty("db2Pass");
			String driverDB2ClassName ="driverDB2ClassName" ; 
			Class.forName(driverDB2ClassName) ;
			con = DriverManager.getConnection(db2Url,db2User,db2Pass);
		    return con;
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return this.getDB2Connection();
		} catch (IOException e) {
			System.out.println(e);
			return this.getDB2Connection();
		}
	}
	
	protected Connection getIDSConnectionFromProperties() throws ClassNotFoundException, SQLException {
		try {
			Properties props = this.getProperties();
			Connection con = null;
			String dbUrl = props.getProperty("dbUrl"); 
			String dbUser = props.getProperty("dbUser");
			String dbPass = props.getProperty("dbPass");
			String driverClassName = props.getProperty("driverClassName"); 
			Class.forName(driverClassName);
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			return con;
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return this.getIDSConnection();
		} catch (IOException e) {
			System.out.println(e);
			return this.getIDSConnection();
		}
	}
	protected synchronized Properties getProperties() throws FileNotFoundException, IOException{
		if (props == null) {
			props = new Properties();
			props.load(new FileInputStream("setup.cfg"));
		}
		return props;
	}
	/**@param conn conexion con una base de datos
	 * @param rs ResultSet con datos de una consulta
	 * Este metodo cierra la conexion que es pasada como parametro liberando
	 * recursos tanto de la conexion como del resultset*/
	protected void cerrarConexion ( Connection conn, ResultSet rs )
	{
		try
		{
			if ( conn != null )
				conn.close();
			if ( rs != null )
				rs.close();
		}
		catch ( SQLException e )
		{System.out.println("Problemas al cerrar conexion: " + e.getMessage());}			
	}
	
	/**@param conn conexion con una base de datos
	 * Este metodo cierra la conexion que es pasada como parametro*/
	protected void cerrarConexion ( Connection conn )
	{
		try
		{
			if ( conn != null )
				conn.close();
		}
		catch ( SQLException e )
		{System.out.println("Problemas al cerrar conexion: " + e.getMessage());}			
	}
}
