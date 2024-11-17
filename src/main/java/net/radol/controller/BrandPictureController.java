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

import net.radol.dto.BrandPictureDTO;
import net.radol.service.BrandPictureService;

@RestController
@RequestMapping("/api/brand-pictures")
public class BrandPictureController implements CrudController<BrandPictureDTO, Integer> {

    private final BrandPictureService brandPictureService;

    public BrandPictureController(BrandPictureService brandPictureService) {
        this.brandPictureService = brandPictureService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<BrandPictureDTO>> getAll() {
        List<BrandPictureDTO> brandPictures = brandPictureService.findAll();
        return new ResponseEntity<>(brandPictures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<BrandPictureDTO> getById(@PathVariable Integer id) {
        BrandPictureDTO brandPicture = brandPictureService.findById(id);
        return new ResponseEntity<>(brandPicture, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<BrandPictureDTO> create(@RequestBody BrandPictureDTO dto) {
        BrandPictureDTO brandPicture = brandPictureService.save(dto);
        return new ResponseEntity<>(brandPicture, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<BrandPictureDTO> update(@PathVariable Integer id, @RequestBody BrandPictureDTO dto) {
        BrandPictureDTO brandPicture = brandPictureService.update(id, dto);
        return new ResponseEntity<>(brandPicture, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        brandPictureService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
