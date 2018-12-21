package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Admin findByLogin(String login);
	
}
