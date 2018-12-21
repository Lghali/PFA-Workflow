package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.Documenttype;

public interface DocumenttypeRepository extends JpaRepository<Documenttype, Long> {
	
}
