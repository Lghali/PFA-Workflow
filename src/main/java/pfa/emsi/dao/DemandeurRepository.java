package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.Demandeur;

public interface DemandeurRepository extends JpaRepository<Demandeur, Long> {
	public Demandeur findByLogin(String login);
	
}
