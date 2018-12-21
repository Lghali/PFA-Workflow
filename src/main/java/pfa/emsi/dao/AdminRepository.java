package pfa.emsi.dao;

import java.awt.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	public List findByLogin(String login);
	

}
