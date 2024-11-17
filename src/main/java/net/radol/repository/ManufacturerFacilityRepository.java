package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.ManufacturerFacility;

@Repository
public interface ManufacturerFacilityRepository extends JpaRepository<ManufacturerFacility, Integer> {
    // Custom query methods can be added here if needed
}