package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Additional query methods if needed
}
