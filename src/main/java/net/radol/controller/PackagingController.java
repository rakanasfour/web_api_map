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

import net.radol.dto.PackagingDTO;
import net.radol.service.PackagingService;

@RestController
@RequestMapping("/api/packaging")
public class PackagingController implements CrudController<PackagingDTO, Integer> {

    private final PackagingService packagingService;

    public PackagingController(PackagingService packagingService) {
        this.packagingService = packagingService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PackagingDTO>> getAll() {
        List<PackagingDTO> packagingList = packagingService.findAll();
        return new ResponseEntity<>(packagingList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<PackagingDTO> getById(@PathVariable Integer id) {
        PackagingDTO packaging = packagingService.findById(id);
        return new ResponseEntity<>(packaging, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<PackagingDTO> create(@RequestBody PackagingDTO dto) {
        PackagingDTO packaging = packagingService.save(dto);
        return new ResponseEntity<>(packaging, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<PackagingDTO> update(@PathVariable Integer id, @RequestBody PackagingDTO dto) {
        PackagingDTO packaging = packagingService.update(id, dto);
        return new ResponseEntity<>(packaging, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        packagingService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
