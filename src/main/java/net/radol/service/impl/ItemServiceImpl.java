package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ItemDTO;
import net.radol.mapper.ItemMapper;
import net.radol.model.Item;
import net.radol.repository.ItemRepository;
import net.radol.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDTO save(ItemDTO dto) {
        Item item = itemMapper.toEntity(dto);
        return itemMapper.toDTO(itemRepository.save(item));
    }

    @Override
    public ItemDTO findById(Integer id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public List<ItemDTO> findAll() {
        return itemRepository.findAll().stream()
                .map(itemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO update(Integer id, ItemDTO dto) {
        Item item = itemMapper.toEntity(dto);
        item.setItemId(id);
        return itemMapper.toDTO(itemRepository.save(item));
    }

    @Override
    public void deleteById(Integer id) {
        itemRepository.deleteById(id);
    }
}
