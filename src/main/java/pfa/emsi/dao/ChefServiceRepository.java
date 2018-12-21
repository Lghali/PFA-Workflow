package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.ChefService;

public interface ChefServiceRepository extends JpaRepository<ChefService, Long> {
	public ChefService findByLogin(String login);
	
}
