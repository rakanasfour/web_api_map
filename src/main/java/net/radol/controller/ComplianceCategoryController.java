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

import net.radol.dto.ComplianceCategoryDTO;
import net.radol.service.ComplianceCategoryService;

@RestController
@RequestMapping("/api/compliance-categories")
public class ComplianceCategoryController implements CrudController<ComplianceCategoryDTO, Integer> {

    private final ComplianceCategoryService complianceCategoryService;

    public ComplianceCategoryController(ComplianceCategoryService complianceCategoryService) {
        this.complianceCategoryService = complianceCategoryService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ComplianceCategoryDTO>> getAll() {
        List<ComplianceCategoryDTO> complianceCategories = complianceCategoryService.findAll();
        return new ResponseEntity<>(complianceCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ComplianceCategoryDTO> getById(@PathVariable Integer id) {
        ComplianceCategoryDTO complianceCategory = complianceCategoryService.findById(id);
        return new ResponseEntity<>(complianceCategory, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ComplianceCategoryDTO> create(@RequestBody ComplianceCategoryDTO dto) {
        ComplianceCategoryDTO complianceCategory = complianceCategoryService.save(dto);
        return new ResponseEntity<>(complianceCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ComplianceCategoryDTO> update(@PathVariable Integer id, @RequestBody ComplianceCategoryDTO dto) {
        ComplianceCategoryDTO complianceCategory = complianceCategoryService.update(id, dto);
        return new ResponseEntity<>(complianceCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        complianceCategoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
