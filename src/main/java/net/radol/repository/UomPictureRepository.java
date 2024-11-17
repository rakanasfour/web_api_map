package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.UomPicture;

@Repository
public interface UomPictureRepository extends JpaRepository<UomPicture, Integer> {
}