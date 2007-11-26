package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import scr.entidades.Usuario;

public class LoginDao extends JdbcManager {
	public Usuario buscarPorNombreYPass(String nombre, String password){ 
		Connection conn = null;
		ResultSet rs = null;
		Usuario usr = null;
		try {
		conn = this.getIDSConnectionFromProperties();
		
		String query = "SELECT * FROM usuario u " +
				"WHERE u.uoNombre = ? and u.uoPassword = ? ";
		
		PreparedStatement pStatement = conn.prepareStatement(query);
		pStatement.setString(1, nombre);
		pStatement.setString(2, password);
		rs = pStatement.executeQuery();		
		
		if(rs.next()){
			usr = this.rellenarUsuario(rs,conn);	
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.cerrarConexion(conn,rs);
		}
		return usr;
	}
	
	private Usuario rellenarUsuario(ResultSet rs, Connection conn) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt(1));
		usuario.setIdProductor(rs.getInt(2));
		usuario.setNombre(rs.getString(3));
		usuario.setIdRol(this.setRolUsuario(usuario.getId(),conn));
		return usuario;
		
	}

	private int setRolUsuario(int id, Connection conn) {
		ResultSet rs = null;
		int idRol = 0;
		try {
		String query = "SELECT ruoIdRol FROM rolDeUsuario " +
				"WHERE ruoIdUsuario = ? ";
		
		PreparedStatement pStatement = conn.prepareStatement(query);
		pStatement.setInt(1, id);
		rs = pStatement.executeQuery();		
		if(rs.next()){
			idRol = rs.getInt(1);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idRol;
	}

}
