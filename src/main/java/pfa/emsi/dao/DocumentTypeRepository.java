package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.DocumentType;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
	
}
