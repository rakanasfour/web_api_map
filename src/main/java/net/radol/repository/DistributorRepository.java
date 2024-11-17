package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.Distributor;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
    // Custom query methods can be added here if needed
}