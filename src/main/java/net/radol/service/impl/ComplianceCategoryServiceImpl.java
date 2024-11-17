package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ComplianceCategoryDTO;
import net.radol.mapper.ComplianceCategoryMapper;
import net.radol.model.ComplianceCategory;
import net.radol.repository.ComplianceCategoryRepository;
import net.radol.service.ComplianceCategoryService;
@Service
public class ComplianceCategoryServiceImpl implements ComplianceCategoryService {
    @Autowired
    private final ComplianceCategoryRepository complianceCategoryRepository;
    private final ComplianceCategoryMapper complianceCategoryMapper;

    public ComplianceCategoryServiceImpl(ComplianceCategoryRepository complianceCategoryRepository, ComplianceCategoryMapper complianceCategoryMapper) {
        this.complianceCategoryRepository = complianceCategoryRepository;
        this.complianceCategoryMapper = complianceCategoryMapper;
    }

    @Override
    public ComplianceCategoryDTO save(ComplianceCategoryDTO dto) {
        ComplianceCategory complianceCategory = complianceCategoryMapper.toEntity(dto);
        return complianceCategoryMapper.toDTO(complianceCategoryRepository.save(complianceCategory));
    }

    @Override
    public ComplianceCategoryDTO findById(Integer id) {
        return complianceCategoryRepository.findById(id)
                .map(complianceCategoryMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("ComplianceCategory not found"));
    }

    @Override
    public List<ComplianceCategoryDTO> findAll() {
        return complianceCategoryRepository.findAll().stream()
                .map(complianceCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ComplianceCategoryDTO update(Integer id, ComplianceCategoryDTO dto) {
        ComplianceCategory complianceCategory = complianceCategoryMapper.toEntity(dto);
        complianceCategory.setComplianceCategoryId(id);
        return complianceCategoryMapper.toDTO(complianceCategoryRepository.save(complianceCategory));
    }

    @Override
    public void deleteById(Integer id) {
        complianceCategoryRepository.deleteById(id);
    }
}
