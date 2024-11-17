package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ItemChannelDTO;
import net.radol.mapper.ItemsChannelsMapper;
import net.radol.model.ItemChannel;
import net.radol.repository.ItemChannelRepository;
import net.radol.service.ItemChannelService;

@Service
public class ItemChannelServiceImpl implements ItemChannelService {
    @Autowired
    private final ItemChannelRepository itemChannelRepository;
    private final ItemsChannelsMapper itemChannelMapper;

    public ItemChannelServiceImpl(ItemChannelRepository itemChannelRepository, ItemsChannelsMapper itemChannelMapper) {
        this.itemChannelRepository = itemChannelRepository;
        this.itemChannelMapper = itemChannelMapper;
    }

    @Override
    public ItemChannelDTO save(ItemChannelDTO dto) {
        ItemChannel itemChannel = itemChannelMapper.toEntity(dto);
        return itemChannelMapper.toDTO(itemChannelRepository.save(itemChannel));
    }

    @Override
    public ItemChannelDTO findById(Integer id) {
        return itemChannelRepository.findById(id)
                .map(itemChannelMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("ItemChannel not found"));
    }

    @Override
    public List<ItemChannelDTO> findAll() {
        return itemChannelRepository.findAll().stream()
                .map(itemChannelMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemChannelDTO update(Integer id, ItemChannelDTO dto) {
        ItemChannel itemChannel = itemChannelMapper.toEntity(dto);
        itemChannel.setItemChannelId(id);
        return itemChannelMapper.toDTO(itemChannelRepository.save(itemChannel));
    }

    @Override
    public void deleteById(Integer id) {
        itemChannelRepository.deleteById(id);
    }
}
