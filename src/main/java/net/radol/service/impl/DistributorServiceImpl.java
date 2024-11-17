package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.DistributorDTO;
import net.radol.mapper.DistributorMapper;
import net.radol.model.Distributor;
import net.radol.repository.DistributorRepository;
import net.radol.service.DistributorService;

@Service
public class DistributorServiceImpl implements DistributorService {
    @Autowired
    private final DistributorRepository distributorRepository;
    private final DistributorMapper distributorMapper;

    public DistributorServiceImpl(DistributorRepository distributorRepository, DistributorMapper distributorMapper) {
        this.distributorRepository = distributorRepository;
        this.distributorMapper = distributorMapper;
    }

    @Override
    public DistributorDTO save(DistributorDTO dto) {
        Distributor distributor = distributorMapper.toEntity(dto);
        return distributorMapper.toDTO(distributorRepository.save(distributor));
    }

    @Override
    public DistributorDTO findById(Integer id) {
        return distributorRepository.findById(id)
                .map(distributorMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Distributor not found"));
    }

    @Override
    public List<DistributorDTO> findAll() {
        return distributorRepository.findAll().stream()
                .map(distributorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DistributorDTO update(Integer id, DistributorDTO dto) {
        Distributor distributor = distributorMapper.toEntity(dto);
        distributor.setDistributorId(id);
        return distributorMapper.toDTO(distributorRepository.save(distributor));
    }

    @Override
    public void deleteById(Integer id) {
        distributorRepository.deleteById(id);
    }
}
