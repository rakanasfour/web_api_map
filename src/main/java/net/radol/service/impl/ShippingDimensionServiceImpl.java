package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ShippingDimensionDTO;
import net.radol.mapper.ShippingDimensionMapper;
import net.radol.model.ShippingDimension;
import net.radol.repository.ShippingDimensionRepository;
import net.radol.service.ShippingDimensionService;

@Service
public class ShippingDimensionServiceImpl implements ShippingDimensionService {
    @Autowired
    private final ShippingDimensionRepository shippingDimensionRepository;
    private final ShippingDimensionMapper shippingDimensionMapper;

    public ShippingDimensionServiceImpl(ShippingDimensionRepository shippingDimensionRepository, ShippingDimensionMapper shippingDimensionMapper) {
        this.shippingDimensionRepository = shippingDimensionRepository;
        this.shippingDimensionMapper = shippingDimensionMapper;
    }

    @Override
    public ShippingDimensionDTO save(ShippingDimensionDTO dto) {
        ShippingDimension shippingDimension = shippingDimensionMapper.toEntity(dto);
        return shippingDimensionMapper.toDTO(shippingDimensionRepository.save(shippingDimension));
    }

    @Override
    public ShippingDimensionDTO findById(Integer id) {
        return shippingDimensionRepository.findById(id)
                .map(shippingDimensionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("ShippingDimension not found"));
    }

    @Override
    public List<ShippingDimensionDTO> findAll() {
        return shippingDimensionRepository.findAll().stream()
                .map(shippingDimensionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShippingDimensionDTO update(Integer id, ShippingDimensionDTO dto) {
        ShippingDimension shippingDimension = shippingDimensionMapper.toEntity(dto);
        shippingDimension.setShippingDimensionId(id);
        return shippingDimensionMapper.toDTO(shippingDimensionRepository.save(shippingDimension));
    }

    @Override
    public void deleteById(Integer id) {
        shippingDimensionRepository.deleteById(id);
    }
}