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

import net.radol.dto.ManufacturerDTO;
import net.radol.service.ManufacturerService;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController implements CrudController<ManufacturerDTO, Integer> {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ManufacturerDTO>> getAll() {
        List<ManufacturerDTO> manufacturers = manufacturerService.findAll();
        return new ResponseEntity<>(manufacturers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ManufacturerDTO> getById(@PathVariable Integer id) {
        ManufacturerDTO manufacturer = manufacturerService.findById(id);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ManufacturerDTO> create(@RequestBody ManufacturerDTO dto) {
        ManufacturerDTO manufacturer = manufacturerService.save(dto);
        return new ResponseEntity<>(manufacturer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ManufacturerDTO> update(@PathVariable Integer id, @RequestBody ManufacturerDTO dto) {
        ManufacturerDTO manufacturer = manufacturerService.update(id, dto);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        manufacturerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
