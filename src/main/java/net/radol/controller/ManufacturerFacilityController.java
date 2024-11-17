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

import net.radol.dto.ManufacturerFacilityDTO;
import net.radol.service.ManufacturerFacilityService;

@RestController
@RequestMapping("/api/manufacturer-facilities")
public class ManufacturerFacilityController implements CrudController<ManufacturerFacilityDTO, Integer> {

    private final ManufacturerFacilityService manufacturerFacilityService;

    public ManufacturerFacilityController(ManufacturerFacilityService manufacturerFacilityService) {
        this.manufacturerFacilityService = manufacturerFacilityService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ManufacturerFacilityDTO>> getAll() {
        List<ManufacturerFacilityDTO> manufacturerFacilities = manufacturerFacilityService.findAll();
        return new ResponseEntity<>(manufacturerFacilities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ManufacturerFacilityDTO> getById(@PathVariable Integer id) {
        ManufacturerFacilityDTO manufacturerFacility = manufacturerFacilityService.findById(id);
        return new ResponseEntity<>(manufacturerFacility, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ManufacturerFacilityDTO> create(@RequestBody ManufacturerFacilityDTO dto) {
        ManufacturerFacilityDTO manufacturerFacility = manufacturerFacilityService.save(dto);
        return new ResponseEntity<>(manufacturerFacility, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ManufacturerFacilityDTO> update(@PathVariable Integer id, @RequestBody ManufacturerFacilityDTO dto) {
        ManufacturerFacilityDTO manufacturerFacility = manufacturerFacilityService.update(id, dto);
        return new ResponseEntity<>(manufacturerFacility, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        manufacturerFacilityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
