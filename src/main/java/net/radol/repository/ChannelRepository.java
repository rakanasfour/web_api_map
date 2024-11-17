package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.radol.model.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {
}