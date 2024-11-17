package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ManufacturerPricingDTO;
import net.radol.mapper.ManufacturerPricingMapper;
import net.radol.model.ManufacturerPricing;
import net.radol.repository.ManufacturerPricingRepository;
import net.radol.service.ManufacturerPricingService;

@Service
public class ManufacturerPricingServiceImpl implements ManufacturerPricingService {
    @Autowired
    private final ManufacturerPricingRepository manufacturerPricingRepository;
    private final ManufacturerPricingMapper manufacturerPricingMapper;

    public ManufacturerPricingServiceImpl(ManufacturerPricingRepository manufacturerPricingRepository, ManufacturerPricingMapper manufacturerPricingMapper) {
        this.manufacturerPricingRepository = manufacturerPricingRepository;
        this.manufacturerPricingMapper = manufacturerPricingMapper;
    }

    @Override
    public ManufacturerPricingDTO save(ManufacturerPricingDTO dto) {
        ManufacturerPricing manufacturerPricing = manufacturerPricingMapper.toEntity(dto);
        return manufacturerPricingMapper.toDTO(manufacturerPricingRepository.save(manufacturerPricing));
    }

    @Override
    public ManufacturerPricingDTO findById(Integer id) {
        return manufacturerPricingRepository.findById(id)
                .map(manufacturerPricingMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("ManufacturerPricing not found"));
    }

    @Override
    public List<ManufacturerPricingDTO> findAll() {
        return manufacturerPricingRepository.findAll().stream()
                .map(manufacturerPricingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ManufacturerPricingDTO update(Integer id, ManufacturerPricingDTO dto) {
        ManufacturerPricing manufacturerPricing = manufacturerPricingMapper.toEntity(dto);
        manufacturerPricing.setPricingId(id);
        return manufacturerPricingMapper.toDTO(manufacturerPricingRepository.save(manufacturerPricing));
    }

    @Override
    public void deleteById(Integer id) {
        manufacturerPricingRepository.deleteById(id);
    }
}
