package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.ManufacturerPricing;

@Repository
public interface ManufacturerPricingRepository extends JpaRepository<ManufacturerPricing, Integer> {
    // Custom query methods can be added here if needed
}