package cl.duoc.trabajo1.utils;

public class RutUtils {

	private RutUtils() {
		// Private constructor
	}

	public static Boolean validarRut(String rut) {

		rut = retornaRutLimpio(rut);
		
		if (rut.length() > 0) {

			if (rut.indexOf("-") > -1) {
				// Creamos un arreglo con el rut y el digito verificador
				String[] rut_dv = rut.split("-");
				// Las partes del rut (numero y dv) deben tener una longitud
				// positiva
				if (rut_dv.length == 2) {
					// Capturamos error (al convertir un string a entero)
					try {
						int numRut = Integer.parseInt(rut_dv[0]);
						char dv = rut_dv[1].charAt(0);

						// Validamos que sea un rut valido según la norma
						if (verificaNum(numRut, dv)) {
							return true;
						} else {
							return false;
						}
					} catch (Exception ex) {
						return false;
					}
				}
			}
			return false;
		}
		return false;
	}
	
	/*
     * Método Estático que valida si un rut es válido
     */
    private static boolean verificaNum(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10){
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
    
    public static String retornaRutLimpio(String rut){
    	return rut.trim().replace(".", "");
    }

}
