package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ManufacturerDTO;
import net.radol.mapper.ManufacturerMapper;
import net.radol.model.Manufacturer;
import net.radol.repository.ManufacturerRepository;
import net.radol.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerMapper = manufacturerMapper;
    }

    @Override
    public ManufacturerDTO save(ManufacturerDTO dto) {
        Manufacturer manufacturer = manufacturerMapper.toEntity(dto);
        return manufacturerMapper.toDTO(manufacturerRepository.save(manufacturer));
    }

    @Override
    public ManufacturerDTO findById(Integer id) {
        return manufacturerRepository.findById(id)
                .map(manufacturerMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
    }

    @Override
    public List<ManufacturerDTO> findAll() {
        return manufacturerRepository.findAll().stream()
                .map(manufacturerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ManufacturerDTO update(Integer id, ManufacturerDTO dto) {
        Manufacturer manufacturer = manufacturerMapper.toEntity(dto);
        manufacturer.setManufacturerId(id);
        return manufacturerMapper.toDTO(manufacturerRepository.save(manufacturer));
    }

    @Override
    public void deleteById(Integer id) {
        manufacturerRepository.deleteById(id);
    }
}
