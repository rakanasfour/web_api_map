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

import net.radol.dto.ModelPictureDTO;
import net.radol.service.ModelPictureService;

@RestController
@RequestMapping("/api/model-pictures")
public class ModelPictureController implements CrudController<ModelPictureDTO, Integer> {

    private final ModelPictureService modelPictureService;

    public ModelPictureController(ModelPictureService modelPictureService) {
        this.modelPictureService = modelPictureService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ModelPictureDTO>> getAll() {
        List<ModelPictureDTO> modelPictures = modelPictureService.findAll();
        return new ResponseEntity<>(modelPictures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ModelPictureDTO> getById(@PathVariable Integer id) {
        ModelPictureDTO modelPicture = modelPictureService.findById(id);
        return new ResponseEntity<>(modelPicture, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ModelPictureDTO> create(@RequestBody ModelPictureDTO dto) {
        ModelPictureDTO modelPicture = modelPictureService.save(dto);
        return new ResponseEntity<>(modelPicture, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ModelPictureDTO> update(@PathVariable Integer id, @RequestBody ModelPictureDTO dto) {
        ModelPictureDTO modelPicture = modelPictureService.update(id, dto);
        return new ResponseEntity<>(modelPicture, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        modelPictureService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
