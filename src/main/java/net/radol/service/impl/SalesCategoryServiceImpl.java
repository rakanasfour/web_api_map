package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.SalesCategoryDTO;
import net.radol.mapper.SalesCategoryMapper;
import net.radol.model.SalesCategory;
import net.radol.repository.SalesCategoryRepository;
import net.radol.service.SalesCategoryService;

@Service
public class SalesCategoryServiceImpl implements SalesCategoryService {
	
    @Autowired
    private final SalesCategoryRepository salesCategoryRepository;
    private final SalesCategoryMapper salesCategoryMapper;

    public SalesCategoryServiceImpl(SalesCategoryRepository salesCategoryRepository, SalesCategoryMapper salesCategoryMapper) {
        this.salesCategoryRepository = salesCategoryRepository;
        this.salesCategoryMapper = salesCategoryMapper;
    }

    @Override
    public SalesCategoryDTO save(SalesCategoryDTO dto) {
        SalesCategory salesCategory = salesCategoryMapper.toEntity(dto);
        return salesCategoryMapper.toDTO(salesCategoryRepository.save(salesCategory));
    }

    @Override
    public SalesCategoryDTO findById(Integer id) {
        return salesCategoryRepository.findById(id)
                .map(salesCategoryMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("SalesCategory not found"));
    }

    @Override
    public List<SalesCategoryDTO> findAll() {
        return salesCategoryRepository.findAll().stream()
                .map(salesCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SalesCategoryDTO update(Integer id, SalesCategoryDTO dto) {
        SalesCategory salesCategory = salesCategoryMapper.toEntity(dto);
        salesCategory.setSalesCategoryId(id);
        return salesCategoryMapper.toDTO(salesCategoryRepository.save(salesCategory));
    }
    
    @Override
    public void deleteById(Integer id) {
    	salesCategoryRepository.deleteById(id);
    }

   
}
