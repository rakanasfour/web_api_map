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

import net.radol.dto.ManufacturerPricingDTO;
import net.radol.service.ManufacturerPricingService;

@RestController
@RequestMapping("/api/manufacturer-pricing")
public class ManufacturerPricingController implements CrudController<ManufacturerPricingDTO, Integer> {

    private final ManufacturerPricingService manufacturerPricingService;

    public ManufacturerPricingController(ManufacturerPricingService manufacturerPricingService) {
        this.manufacturerPricingService = manufacturerPricingService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ManufacturerPricingDTO>> getAll() {
        List<ManufacturerPricingDTO> manufacturerPricings = manufacturerPricingService.findAll();
        return new ResponseEntity<>(manufacturerPricings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ManufacturerPricingDTO> getById(@PathVariable Integer id) {
        ManufacturerPricingDTO manufacturerPricing = manufacturerPricingService.findById(id);
        return new ResponseEntity<>(manufacturerPricing, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ManufacturerPricingDTO> create(@RequestBody ManufacturerPricingDTO dto) {
        ManufacturerPricingDTO manufacturerPricing = manufacturerPricingService.save(dto);
        return new ResponseEntity<>(manufacturerPricing, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ManufacturerPricingDTO> update(@PathVariable Integer id, @RequestBody ManufacturerPricingDTO dto) {
        ManufacturerPricingDTO manufacturerPricing = manufacturerPricingService.update(id, dto);
        return new ResponseEntity<>(manufacturerPricing, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        manufacturerPricingService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
