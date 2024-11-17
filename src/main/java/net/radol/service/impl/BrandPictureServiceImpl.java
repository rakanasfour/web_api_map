package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.BrandPictureDTO;
import net.radol.mapper.BrandPictureMapper;
import net.radol.model.BrandPicture;
import net.radol.repository.BrandPictureRepository;
import net.radol.service.BrandPictureService;

@Service
public class BrandPictureServiceImpl implements BrandPictureService {
    @Autowired
    private final BrandPictureRepository brandPictureRepository;
    private final BrandPictureMapper brandPictureMapper;

    public BrandPictureServiceImpl(BrandPictureRepository brandPictureRepository, BrandPictureMapper brandPictureMapper) {
        this.brandPictureRepository = brandPictureRepository;
        this.brandPictureMapper = brandPictureMapper;
    }

    @Override
    public BrandPictureDTO save(BrandPictureDTO dto) {
        BrandPicture brandPicture = brandPictureMapper.toEntity(dto);
        return brandPictureMapper.toDTO(brandPictureRepository.save(brandPicture));
    }

    @Override
    public BrandPictureDTO findById(Integer id) {
        return brandPictureRepository.findById(id)
                .map(brandPictureMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("BrandPicture not found"));
    }

    @Override
    public List<BrandPictureDTO> findAll() {
        return brandPictureRepository.findAll().stream()
                .map(brandPictureMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BrandPictureDTO update(Integer id, BrandPictureDTO dto) {
        BrandPicture brandPicture = brandPictureMapper.toEntity(dto);
        brandPicture.setBrandPictureId(id);
        return brandPictureMapper.toDTO(brandPictureRepository.save(brandPicture));
    }

    @Override
    public void deleteById(Integer id) {
        brandPictureRepository.deleteById(id);
    }
}
