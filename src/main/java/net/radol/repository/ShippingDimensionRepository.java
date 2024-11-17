package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.ShippingDimension;

@Repository
public interface ShippingDimensionRepository extends JpaRepository<ShippingDimension, Integer> {
}