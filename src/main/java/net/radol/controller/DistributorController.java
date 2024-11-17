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

import net.radol.dto.DistributorDTO;
import net.radol.service.DistributorService;

@RestController
@RequestMapping("/api/distributors")
public class DistributorController implements CrudController<DistributorDTO, Integer> {

    private final DistributorService distributorService;

    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<DistributorDTO>> getAll() {
        List<DistributorDTO> distributors = distributorService.findAll();
        return new ResponseEntity<>(distributors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DistributorDTO> getById(@PathVariable Integer id) {
        DistributorDTO distributor = distributorService.findById(id);
        return new ResponseEntity<>(distributor, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<DistributorDTO> create(@RequestBody DistributorDTO dto) {
        DistributorDTO distributor = distributorService.save(dto);
        return new ResponseEntity<>(distributor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<DistributorDTO> update(@PathVariable Integer id, @RequestBody DistributorDTO dto) {
        DistributorDTO distributor = distributorService.update(id, dto);
        return new ResponseEntity<>(distributor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        distributorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
