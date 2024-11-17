package net.radol.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CrudController<DTO, ID> {
    ResponseEntity<List<DTO>> getAll();
    ResponseEntity<DTO> getById(ID id);
    ResponseEntity<DTO> create(DTO entity);
    ResponseEntity<DTO> update(ID id, DTO entity);
    ResponseEntity<Void> delete(ID id);
}