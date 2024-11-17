package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.AttributeDTO;
import net.radol.mapper.AttributeMapper;
import net.radol.model.Attribute;
import net.radol.repository.AttributeRepository;
import net.radol.service.AttributeService;

@Service
public class AttributeServiceImpl implements AttributeService {
	@Autowired
	private final AttributeRepository attributeRepository;
    private final AttributeMapper attributeMapper;

  
    public AttributeServiceImpl(AttributeRepository attributeRepository, AttributeMapper attributeMapper) {
        this.attributeRepository = attributeRepository;
        this.attributeMapper = attributeMapper;
    }

	@Override
	public AttributeDTO save(AttributeDTO dto) {
		Attribute attribute = attributeMapper.toEntity(dto);
	    return attributeMapper.toDTO(attributeRepository.save(attribute));
	}

	@Override
	public AttributeDTO findById(Integer id) {
	    return attributeRepository.findById(id)
	            .map(attributeMapper::toDTO)
	            .orElseThrow(() -> new RuntimeException("Attribute not found"));
	}

	@Override
	public List<AttributeDTO> findAll() {
		return attributeRepository.findAll().stream()
                .map(attributeMapper::toDTO)
                .collect(Collectors.toList());
	}

	@Override
	public AttributeDTO update(Integer id, AttributeDTO dto) {
		Attribute attribute = attributeMapper.toEntity(dto);
		attribute.setAttributeId(id);
        return attributeMapper.toDTO(attributeRepository.save(attribute));
	}

	@Override
	public void deleteById(Integer id) {
		attributeRepository.deleteById(id);		
	}


}