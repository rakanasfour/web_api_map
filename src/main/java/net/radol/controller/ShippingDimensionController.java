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

import net.radol.dto.ShippingDimensionDTO;
import net.radol.service.ShippingDimensionService;

@RestController
@RequestMapping("/api/shipping-dimensions")
public class ShippingDimensionController implements CrudController<ShippingDimensionDTO, Integer> {

    private final ShippingDimensionService shippingDimensionService;

    public ShippingDimensionController(ShippingDimensionService shippingDimensionService) {
        this.shippingDimensionService = shippingDimensionService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ShippingDimensionDTO>> getAll() {
        List<ShippingDimensionDTO> shippingDimensions = shippingDimensionService.findAll();
        return new ResponseEntity<>(shippingDimensions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ShippingDimensionDTO> getById(@PathVariable Integer id) {
        ShippingDimensionDTO shippingDimension = shippingDimensionService.findById(id);
        return new ResponseEntity<>(shippingDimension, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ShippingDimensionDTO> create(@RequestBody ShippingDimensionDTO dto) {
        ShippingDimensionDTO shippingDimension = shippingDimensionService.save(dto);
        return new ResponseEntity<>(shippingDimension, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ShippingDimensionDTO> update(@PathVariable Integer id, @RequestBody ShippingDimensionDTO dto) {
        ShippingDimensionDTO shippingDimension = shippingDimensionService.update(id, dto);
        return new ResponseEntity<>(shippingDimension, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        shippingDimensionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
