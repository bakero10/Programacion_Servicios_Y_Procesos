package cf.iesguara.springboot01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cf.iesguara.springboot01.model.Aula;

public interface AulaRepository extends JpaRepository<Aula, Long>{
	
}
