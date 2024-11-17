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

import net.radol.dto.UomPictureDTO;
import net.radol.service.UomPictureService;

@RestController
@RequestMapping("/api/uom-pictures")
public class UomPictureController implements CrudController<UomPictureDTO, Integer> {

    private final UomPictureService uomPictureService;

    public UomPictureController(UomPictureService uomPictureService) {
        this.uomPictureService = uomPictureService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UomPictureDTO>> getAll() {
        List<UomPictureDTO> uomPictures = uomPictureService.findAll();
        return new ResponseEntity<>(uomPictures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UomPictureDTO> getById(@PathVariable Integer id) {
        UomPictureDTO uomPicture = uomPictureService.findById(id);
        return new ResponseEntity<>(uomPicture, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<UomPictureDTO> create(@RequestBody UomPictureDTO dto) {
        UomPictureDTO uomPicture = uomPictureService.save(dto);
        return new ResponseEntity<>(uomPicture, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UomPictureDTO> update(@PathVariable Integer id, @RequestBody UomPictureDTO dto) {
        UomPictureDTO uomPicture = uomPictureService.update(id, dto);
        return new ResponseEntity<>(uomPicture, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        uomPictureService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
