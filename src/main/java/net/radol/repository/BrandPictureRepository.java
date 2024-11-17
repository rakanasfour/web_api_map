package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.BrandPicture;

@Repository
public interface BrandPictureRepository extends JpaRepository<BrandPicture, Integer> {
    // Custom query methods can be added here if needed
}