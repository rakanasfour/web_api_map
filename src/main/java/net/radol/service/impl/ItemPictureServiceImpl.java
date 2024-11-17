package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ItemPictureDTO;
import net.radol.mapper.ItemPictureMapper;
import net.radol.model.ItemPicture;
import net.radol.repository.ItemPictureRepository;
import net.radol.service.ItemPictureService;

@Service
public class ItemPictureServiceImpl implements ItemPictureService {
    @Autowired
    private final ItemPictureRepository itemPictureRepository;
    private final ItemPictureMapper itemPictureMapper;

    public ItemPictureServiceImpl(ItemPictureRepository itemPictureRepository, ItemPictureMapper itemPictureMapper) {
        this.itemPictureRepository = itemPictureRepository;
        this.itemPictureMapper = itemPictureMapper;
    }

    @Override
    public ItemPictureDTO save(ItemPictureDTO dto) {
        ItemPicture itemPicture = itemPictureMapper.toEntity(dto);
        return itemPictureMapper.toDTO(itemPictureRepository.save(itemPicture));
    }

    @Override
    public ItemPictureDTO findById(Integer id) {
        return itemPictureRepository.findById(id)
                .map(itemPictureMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("ItemPicture not found"));
    }

    @Override
    public List<ItemPictureDTO> findAll() {
        return itemPictureRepository.findAll().stream()
                .map(itemPictureMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemPictureDTO update(Integer id, ItemPictureDTO dto) {
        ItemPicture itemPicture = itemPictureMapper.toEntity(dto);
        itemPicture.setItemPictureId(id);
        return itemPictureMapper.toDTO(itemPictureRepository.save(itemPicture));
    }

    @Override
    public void deleteById(Integer id) {
        itemPictureRepository.deleteById(id);
    }
}
