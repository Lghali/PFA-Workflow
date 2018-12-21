package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
	
}
