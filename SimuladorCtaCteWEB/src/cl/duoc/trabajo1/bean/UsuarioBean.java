package cl.duoc.trabajo1.bean;

import cl.duoc.trabajo1.dao.IUsuarioDAO;
import cl.duoc.trabajo1.dao.impl.UsuarioDAO;
import cl.duoc.trabajo1.to.UsuarioTO;

public class UsuarioBean implements IUsuarioBean {

	private IUsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@Override
	public UsuarioTO recuperarUsuario(String rut, String contrasena) {
		return (UsuarioTO) ((!rut.isEmpty() && !contrasena.isEmpty()) ? usuarioDAO.recuperarUsuario(rut, contrasena) : false);
	}
	
	@Override
	public Boolean RegistarUsuario(UsuarioTO usuario) {
		return (usuario != null) ? usuarioDAO.RegistarUsuario(usuario) : false;
	}
}
