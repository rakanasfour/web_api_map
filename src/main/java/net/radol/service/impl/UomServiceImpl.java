package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.UomDTO;
import net.radol.mapper.UomMapper;
import net.radol.model.Uom;
import net.radol.repository.UomRepository;
import net.radol.service.UomService;

@Service
public class UomServiceImpl implements UomService {
    @Autowired
    private final UomRepository uomRepository;
    private final UomMapper uomMapper;

    public UomServiceImpl(UomRepository uomRepository, UomMapper uomMapper) {
        this.uomRepository = uomRepository;
        this.uomMapper = uomMapper;
    }

    @Override
    public UomDTO save(UomDTO dto) {
        Uom uom = uomMapper.toEntity(dto);
        return uomMapper.toDTO(uomRepository.save(uom));
    }

    @Override
    public UomDTO findById(Integer id) {
        return uomRepository.findById(id)
                .map(uomMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Uom not found"));
    }

    @Override
    public List<UomDTO> findAll() {
        return uomRepository.findAll().stream()
                .map(uomMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UomDTO update(Integer id, UomDTO dto) {
        Uom uom = uomMapper.toEntity(dto);
        uom.setUomId(id);
        return uomMapper.toDTO(uomRepository.save(uom));
    }

    @Override
    public void deleteById(Integer id) {
        uomRepository.deleteById(id);
    }
}
