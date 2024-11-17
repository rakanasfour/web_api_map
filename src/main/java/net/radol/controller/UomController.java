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

import net.radol.dto.UomDTO;
import net.radol.service.UomService;

@RestController
@RequestMapping("/api/uoms")
public class UomController implements CrudController<UomDTO, Integer> {

    private final UomService uomService;

    public UomController(UomService uomService) {
        this.uomService = uomService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UomDTO>> getAll() {
        List<UomDTO> uoms = uomService.findAll();
        return new ResponseEntity<>(uoms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UomDTO> getById(@PathVariable Integer id) {
        UomDTO uom = uomService.findById(id);
        return new ResponseEntity<>(uom, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<UomDTO> create(@RequestBody UomDTO dto) {
        UomDTO uom = uomService.save(dto);
        return new ResponseEntity<>(uom, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UomDTO> update(@PathVariable Integer id, @RequestBody UomDTO dto) {
        UomDTO uom = uomService.update(id, dto);
        return new ResponseEntity<>(uom, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        uomService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
