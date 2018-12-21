package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.Directeur;

public interface DirecteurRepository extends JpaRepository<Directeur, Long> {
	public Directeur findByLogin(String login);
	
}
