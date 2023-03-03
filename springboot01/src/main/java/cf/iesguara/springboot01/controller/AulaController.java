package cf.iesguara.springboot01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cf.iesguara.springboot01.model.Aula;
import cf.iesguara.springboot01.service.AulaService;

@RestController
@RequestMapping("/aulas") //Ruta principal por donde va a venir todo
public class AulaController {
	@Autowired
	private AulaService aulaService;
	
	public AulaController(AulaService aulaService) {
		super();
		this.aulaService = aulaService;
	}
	// GET /aulas/23 < -- sería un ejemplo de id
	@GetMapping("{id}")
	public ResponseEntity<Aula> mostrarAula(@PathVariable("id") long idCliente){
		return new ResponseEntity<Aula>(aulaService.mostrarAulaId(idCliente), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aula> guardarAula(@RequestBody Aula aula){
		return new ResponseEntity<Aula>(aulaService.guardarAula(aula),HttpStatus.CREATED);
	}
	
}
