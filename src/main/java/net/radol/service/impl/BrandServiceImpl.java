package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.BrandDTO;
import net.radol.mapper.BrandMapper;
import net.radol.model.Brand;
import net.radol.repository.BrandRepository;
import net.radol.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public BrandDTO save(BrandDTO dto) {
        Brand brand = brandMapper.toEntity(dto);
        return brandMapper.toDTO(brandRepository.save(brand));
    }

    @Override
    public BrandDTO findById(Integer id) {
        return brandRepository.findById(id)
                .map(brandMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    @Override
    public List<BrandDTO> findAll() {
        return brandRepository.findAll().stream()
                .map(brandMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BrandDTO update(Integer id, BrandDTO dto) {
        Brand brand = brandMapper.toEntity(dto);
        brand.setBrandId(id);
        return brandMapper.toDTO(brandRepository.save(brand));
    }

    @Override
    public void deleteById(Integer id) {
        brandRepository.deleteById(id);
    }
}
