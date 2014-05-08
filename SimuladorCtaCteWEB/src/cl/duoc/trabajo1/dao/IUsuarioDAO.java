package cl.duoc.trabajo1.dao;


import cl.duoc.trabajo1.to.UsuarioTO;


public interface IUsuarioDAO {
	
	UsuarioTO recuperarUsuario(String rut, String contrasena);
	
	Boolean RegistarUsuario(UsuarioTO usuario);

}
