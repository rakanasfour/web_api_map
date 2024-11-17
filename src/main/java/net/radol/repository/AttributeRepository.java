package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
    
	
	
}