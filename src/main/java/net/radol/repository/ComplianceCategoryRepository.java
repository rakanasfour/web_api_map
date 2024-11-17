package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.ComplianceCategory;

@Repository
public interface ComplianceCategoryRepository extends JpaRepository<ComplianceCategory, Integer> {
    // Custom query methods can be added here if needed
}