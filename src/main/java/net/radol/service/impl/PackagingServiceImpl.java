package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.PackagingDTO;
import net.radol.mapper.PackagingMapper;
import net.radol.model.Packaging;
import net.radol.repository.PackagingRepository;
import net.radol.service.PackagingService;

@Service
public class PackagingServiceImpl implements PackagingService {
    @Autowired
    private final PackagingRepository packagingRepository;
    private final PackagingMapper packagingMapper;

    public PackagingServiceImpl(PackagingRepository packagingRepository, PackagingMapper packagingMapper) {
        this.packagingRepository = packagingRepository;
        this.packagingMapper = packagingMapper;
    }

    @Override
    public PackagingDTO save(PackagingDTO dto) {
        Packaging packaging = packagingMapper.toEntity(dto);
        return packagingMapper.toDTO(packagingRepository.save(packaging));
    }

    @Override
    public PackagingDTO findById(Integer id) {
        return packagingRepository.findById(id)
                .map(packagingMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Packaging not found"));
    }

    @Override
    public List<PackagingDTO> findAll() {
        return packagingRepository.findAll().stream()
                .map(packagingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PackagingDTO update(Integer id, PackagingDTO dto) {
        Packaging packaging = packagingMapper.toEntity(dto);
        packaging.setPackagingId(id);
        return packagingMapper.toDTO(packagingRepository.save(packaging));
    }

    @Override
    public void deleteById(Integer id) {
        packagingRepository.deleteById(id);
    }
}