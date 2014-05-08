package cl.duoc.trabajo1.dao.impl;

import java.sql.SQLException;

import cl.duoc.trabajo1.dao.IUsuarioDAO;
import cl.duoc.trabajo1.to.UsuarioTO;

public class UsuarioDAO extends GenericDAO implements IUsuarioDAO {
	
	@Override
	public UsuarioTO recuperarUsuario(String rut, String contrasena) {
		
		UsuarioTO usuario = null;
		try 
		{
			conn = ConnectionDAO.getConnection();
			if (conn != null) {
				String query = "SELECT idUsuario, Rut, Nombre, ApellidoP, ApellidoM, Email, FechaNacimiento FROM Usuario WHERE (Rut = ?) AND (Contrasena = ?)";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(0, rut);
				pstmt.setString(1, contrasena);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					usuario = new UsuarioTO();
					usuario.setIdUsuario(rs.getInt("idUsuario"));
					usuario.setRut(rs.getString("Rut"));
					usuario.setNombre(rs.getString("Nombre"));
					usuario.setNombre(rs.getString("ApellidoP"));
					usuario.setNombre(rs.getString("ApellidoM"));
					usuario.setNombre(rs.getString("Email"));
					usuario.setNombre(rs.getString("FechaNacimiento"));
				}
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
			close(rs);
		}
		
		return usuario;
	}
	
	
	@Override
	public Boolean RegistarUsuario(UsuarioTO usuario) {
		boolean resp = false;
		try
		{
			if (conn != null) {
				String query = "INSERT INTO Usuario Rut, Nombre, ApellidoP, ApellidoM, Contrasena, FechaNacimiento, Email) VALUES (?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(0, usuario.getRut());
				pstmt.setString(1, usuario.getNombre());
				pstmt.setString(2, usuario.getApellidoP());
				pstmt.setString(3, usuario.getApellidoM());
				pstmt.setString(4, usuario.getContrasena());
				pstmt.setString(5, usuario.getFechaNacimiento());
				pstmt.setString(6, usuario.getEmail());
				resp = (pstmt.executeUpdate() > 0) ? true : false;
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(conn);
			close(pstmt);
			close(rs);
		}
		
		return resp;
	}
	
	
}
