package cl.duoc.trabajo1.bean;

import cl.duoc.trabajo1.to.UsuarioTO;

public interface IUsuarioBean {

	public UsuarioTO recuperarUsuario(String nombre, String contrasena);

	public Boolean RegistarUsuario(UsuarioTO usuario);
}
