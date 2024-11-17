package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.Uom;

@Repository
public interface UomRepository extends JpaRepository<Uom, Integer> {
}