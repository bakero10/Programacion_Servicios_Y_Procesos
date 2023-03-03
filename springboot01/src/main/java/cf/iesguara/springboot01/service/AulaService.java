package cf.iesguara.springboot01.service;

import cf.iesguara.springboot01.model.Aula;

//AQUI METEREMOS LOS METODOS QUE QUEREMOS PONER
public interface AulaService {
	public Aula mostrarAulaId(long idAula);
	public Aula guardarAula(Aula aula);
}
