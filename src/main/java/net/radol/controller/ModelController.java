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

import net.radol.dto.ModelDTO;
import net.radol.service.ModelService;

@RestController
@RequestMapping("/api/models")
public class ModelController implements CrudController<ModelDTO, Integer> {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ModelDTO>> getAll() {
        List<ModelDTO> models = modelService.findAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ModelDTO> getById(@PathVariable Integer id) {
        ModelDTO model = modelService.findById(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ModelDTO> create(@RequestBody ModelDTO dto) {
        ModelDTO model = modelService.save(dto);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ModelDTO> update(@PathVariable Integer id, @RequestBody ModelDTO dto) {
        ModelDTO model = modelService.update(id, dto);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        modelService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
