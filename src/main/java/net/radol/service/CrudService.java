package net.radol.service;

import java.util.List;

public interface CrudService<DTO, Entity, ID> {
    DTO save(DTO dto);
    DTO findById(ID id);
    List<DTO> findAll();
    DTO update(ID id, DTO dto);
    void deleteById(ID id);
}