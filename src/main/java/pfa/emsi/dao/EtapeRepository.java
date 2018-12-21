package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.Etape;

public interface EtapeRepository extends JpaRepository<Etape, Long> {
	
}
