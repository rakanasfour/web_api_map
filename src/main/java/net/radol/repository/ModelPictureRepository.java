package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.ModelPicture;

@Repository
public interface ModelPictureRepository extends JpaRepository<ModelPicture, Integer> {
    // Custom query methods can be added here if needed
}