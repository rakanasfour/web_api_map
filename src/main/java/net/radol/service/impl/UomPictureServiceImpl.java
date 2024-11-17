package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.UomPictureDTO;
import net.radol.mapper.UomPictureMapper;
import net.radol.model.UomPicture;
import net.radol.repository.UomPictureRepository;
import net.radol.service.UomPictureService;

@Service
public class UomPictureServiceImpl implements UomPictureService {
    @Autowired
    private final UomPictureRepository uomPictureRepository;
    private final UomPictureMapper uomPictureMapper;

    public UomPictureServiceImpl(UomPictureRepository uomPictureRepository, UomPictureMapper uomPictureMapper) {
        this.uomPictureRepository = uomPictureRepository;
        this.uomPictureMapper = uomPictureMapper;
    }

    @Override
    public UomPictureDTO save(UomPictureDTO dto) {
        UomPicture uomPicture = uomPictureMapper.toEntity(dto);
        return uomPictureMapper.toDTO(uomPictureRepository.save(uomPicture));
    }

    @Override
    public UomPictureDTO findById(Integer id) {
        return uomPictureRepository.findById(id)
                .map(uomPictureMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("UomPicture not found"));
    }

    @Override
    public List<UomPictureDTO> findAll() {
        return uomPictureRepository.findAll().stream()
                .map(uomPictureMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UomPictureDTO update(Integer id, UomPictureDTO dto) {
        UomPicture uomPicture = uomPictureMapper.toEntity(dto);
        uomPicture.setUomPictureId(id);
        return uomPictureMapper.toDTO(uomPictureRepository.save(uomPicture));
    }

    @Override
    public void deleteById(Integer id) {
        uomPictureRepository.deleteById(id);
    }
}
