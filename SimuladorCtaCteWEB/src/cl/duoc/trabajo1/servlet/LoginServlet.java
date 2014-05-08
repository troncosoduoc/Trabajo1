package cl.duoc.trabajo1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.duoc.trabajo1.bean.UsuarioBean;
import cl.duoc.trabajo1.to.UsuarioTO;
import cl.duoc.trabajo1.utils.RutUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDisp =  request.getRequestDispatcher("/pages/login.jsp");
		requestDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDisp = request.getRequestDispatcher("/pages/login.jsp");
		
		UsuarioBean usuarioBean = new UsuarioBean();
		String rutLogin = RutUtils.retornaRutLimpio(request.getParameter("rut"));
		String contrasena = request.getParameter("contrasena");
		//valida rut
		if(!RutUtils.validarRut(rutLogin)){
			request.setAttribute("mensajeError", "Rut ingresado es inválido.");
		}
		
		if(rutLogin==null | rutLogin.isEmpty() | contrasena==null | contrasena.isEmpty()){
			request.setAttribute("mensajeError", "Debe rellenar todos los campos.");
		} else{
			UsuarioTO usuarioLogin = usuarioBean.recuperarUsuario(rutLogin, contrasena);

			//Cargar usuario a Session
			request.getSession().setAttribute("UsuarioTO", usuarioLogin);
			
			if(usuarioLogin != null){
				requestDisp = request.getRequestDispatcher("/pages/movimientos.jsp");
			}else{
				request.setAttribute("mensajeError", "Rut o clave de acceso incorrectos.");
			}
		}
		
		requestDisp.forward(request, response);
	}

}
