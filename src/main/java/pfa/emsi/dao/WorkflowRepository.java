package pfa.emsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pfa.emsi.model.Workflow;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
	
}
