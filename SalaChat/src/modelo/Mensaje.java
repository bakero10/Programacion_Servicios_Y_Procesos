package modelo;

import java.io.Serializable;
import java.util.Date;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date fechaHora;
	private String texto;
	private String emisor;
	public Mensaje(String texto, String emisor) {
		super();
		this.fechaHora = new Date();
		this.texto = texto;
		this.emisor = emisor;
	}
	@Override
	public String toString() {
		// (fechahora) juanito: Hola mundo.
		return "(" + fechaHora + ")" + " " + emisor + ":" + texto;
	}
	
	
	
}
