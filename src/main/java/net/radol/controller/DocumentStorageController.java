package net.radol.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.radol.dto.DocumentStorageDTO;
import net.radol.service.DocumentStorageService;

@RestController
@RequestMapping("/api/document-storage")
public class DocumentStorageController implements CrudController<DocumentStorageDTO, Integer> {

    private final DocumentStorageService documentStorageService;

    public DocumentStorageController(DocumentStorageService documentStorageService) {
        this.documentStorageService = documentStorageService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<DocumentStorageDTO>> getAll() {
        List<DocumentStorageDTO> documentStorages = documentStorageService.findAll();
        return new ResponseEntity<>(documentStorages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DocumentStorageDTO> getById(@PathVariable Integer id) {
        DocumentStorageDTO documentStorage = documentStorageService.findById(id);
        return new ResponseEntity<>(documentStorage, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<DocumentStorageDTO> create(@RequestBody DocumentStorageDTO dto) {
        DocumentStorageDTO documentStorage = documentStorageService.save(dto);
        return new ResponseEntity<>(documentStorage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<DocumentStorageDTO> update(@PathVariable Integer id, @RequestBody DocumentStorageDTO dto) {
        DocumentStorageDTO documentStorage = documentStorageService.update(id, dto);
        return new ResponseEntity<>(documentStorage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        documentStorageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
