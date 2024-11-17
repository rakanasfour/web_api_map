package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ItemSalesCategoryDTO;
import net.radol.mapper.ItemSalesCategoryMapper;
import net.radol.model.ItemSalesCategory;
import net.radol.repository.ItemSalesCategoryRepository;
import net.radol.service.ItemSalesCategoryService;

@Service
public class ItemSalesCategoryServiceImpl implements ItemSalesCategoryService {
	
	
    @Autowired
    private final ItemSalesCategoryRepository itemSalesCategoryRepository;
    private final ItemSalesCategoryMapper itemSalesCategoryMapper;

    public ItemSalesCategoryServiceImpl(ItemSalesCategoryRepository itemSalesCategoryRepository, ItemSalesCategoryMapper itemSalesCategoryMapper) {
        this.itemSalesCategoryRepository = itemSalesCategoryRepository;
        this.itemSalesCategoryMapper = itemSalesCategoryMapper;
    }

    @Override
    public ItemSalesCategoryDTO save(ItemSalesCategoryDTO dto) {
        ItemSalesCategory itemSalesCategory = itemSalesCategoryMapper.toEntity(dto);
        return itemSalesCategoryMapper.toDTO(itemSalesCategoryRepository.save(itemSalesCategory));
    }

    @Override
    public ItemSalesCategoryDTO findById(Integer id) {
        return itemSalesCategoryRepository.findById(id)
                .map(itemSalesCategoryMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("ItemSalesCategory not found"));
    }

    @Override
    public List<ItemSalesCategoryDTO> findAll() {
        return itemSalesCategoryRepository.findAll().stream()
                .map(itemSalesCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemSalesCategoryDTO update(Integer id, ItemSalesCategoryDTO dto) {
        ItemSalesCategory itemSalesCategory = itemSalesCategoryMapper.toEntity(dto);
        itemSalesCategory.setItemSalesCategoryId(id);
        return itemSalesCategoryMapper.toDTO(itemSalesCategoryRepository.save(itemSalesCategory));
    }
    
    @Override
    public void deleteById(Integer id) {
        itemSalesCategoryRepository.deleteById(id);
    }



   
}
