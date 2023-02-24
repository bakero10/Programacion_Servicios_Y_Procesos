package cf.iesguara.springboot01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{	//Cuando ponemos esto se pone el Resource en amarillo y lanza el private id.**

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;				//**
	private String nombreRecurso;
	private String nombreCampo;
	private Object valorCampo;
	
	//Montamos el constructor con el mensaje para pasarselo a la exception
	//ALT + S + para generar el contructor
	
	public ResourceNotFoundException(String nombreRecurso, String nombreCampo, Object valorCampo) {
		//Queremos poner recurso 'Aula' con id = 23 no encontrado
		super(String.format("Recurso %s con %s = %s no encontrado. ", nombreRecurso,nombreCampo,valorCampo));
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.valorCampo = valorCampo;
	}
	
	// GETTERS
	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public Object getValorCampo() {
		return valorCampo;
	}

	
	
	
	
	
}
