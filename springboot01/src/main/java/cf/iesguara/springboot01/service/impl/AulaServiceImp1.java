package cf.iesguara.springboot01.service.impl;

import java.util.Optional;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cf.iesguara.springboot01.exception.ResourceNotFoundException;
import cf.iesguara.springboot01.model.Aula;
import cf.iesguara.springboot01.repository.AulaRepository;
import cf.iesguara.springboot01.service.AulaService;
@Service
@Component
public class AulaServiceImp1 implements AulaService {
	
	private AulaRepository aulaRepo;
	
	public AulaServiceImp1(AulaRepository aulaRepo) {
		super();
		this.aulaRepo = aulaRepo;
	}

	@Override
	public Aula mostrarAulaId(long idAula) {
		Optional<Aula> aulaOpt = aulaRepo.findById(idAula);
		if(aulaOpt.isPresent()) {
			return aulaOpt.get();
		}
		else {
			throw new ResourceNotFoundException("Aula", "id", idAula);
		}
	}

	@Override
	public Aula guardarAula(Aula aula) {
		return aulaRepo.save(aula);
	}

}
