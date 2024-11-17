package net.radol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import net.radol.mapper.ChannelMapper;
import net.radol.model.ItemChannel;

@Repository
public interface ItemChannelRepository extends JpaRepository<ItemChannel, Integer> {

    @Transactional
    void deleteAllByMappedChannel(ChannelMapper mappedChannel);
}