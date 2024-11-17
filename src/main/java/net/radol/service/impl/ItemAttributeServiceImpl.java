package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ItemAttributeDTO;
import net.radol.mapper.ItemsAttributesMapper;
import net.radol.model.ItemAttribute;
import net.radol.repository.ItemAttributeRepository;
import net.radol.service.ItemAttributeService;

@Service
public class ItemAttributeServiceImpl implements ItemAttributeService {
    @Autowired
    private final ItemAttributeRepository itemAttributeRepository;
    private final ItemsAttributesMapper itemAttributeMapper;

    public ItemAttributeServiceImpl(ItemAttributeRepository itemAttributeRepository, ItemsAttributesMapper itemAttributeMapper) {
        this.itemAttributeRepository = itemAttributeRepository;
        this.itemAttributeMapper = itemAttributeMapper;
    }

    @Override
    public ItemAttributeDTO save(ItemAttributeDTO dto) {
    	ItemAttribute itemAttribute = itemAttributeMapper.toEntity(dto);
        return itemAttributeMapper.toDTO(itemAttributeRepository.save(itemAttribute));
    }

    @Override
    public ItemAttributeDTO findById(Integer id) {
        return itemAttributeRepository.findById(id)
                .map(itemAttributeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("ItemAttribute not found"));
    }

    @Override
    public List<ItemAttributeDTO> findAll() {
        return itemAttributeRepository.findAll().stream()
                .map(itemAttributeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemAttributeDTO update(Integer id, ItemAttributeDTO dto) {
        ItemAttribute itemAttribute = itemAttributeMapper.toEntity(dto);
        itemAttribute.setItemAttributeId(id);
        return itemAttributeMapper.toDTO(itemAttributeRepository.save(itemAttribute));
    }

    @Override
    public void deleteById(Integer id) {
        itemAttributeRepository.deleteById(id);
    }
}
