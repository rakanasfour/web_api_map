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

import net.radol.dto.AttributeDTO;
import net.radol.service.AttributeService;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController implements CrudController<AttributeDTO, Integer>  {

    private final AttributeService attributeService;


    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping()
	@Override
	public ResponseEntity<List<AttributeDTO>> getAll() {
		List<AttributeDTO> attributes = attributeService.findAll();
	       return new ResponseEntity<>(attributes, HttpStatus.OK);
	}



	@Override
	  @GetMapping("/{id}")
	public ResponseEntity<AttributeDTO> getById( @PathVariable Integer id) {
		AttributeDTO attribute= attributeService.findById(id);
		return new ResponseEntity<>(attribute, HttpStatus.OK);

	}

	@PostMapping
	@Override
	public ResponseEntity<AttributeDTO> create(@RequestBody AttributeDTO dto) {
	
		AttributeDTO attribute= attributeService.save(dto);
		return new ResponseEntity<>(attribute, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<AttributeDTO> update( @PathVariable Integer id, @RequestBody AttributeDTO dto) {
	
		AttributeDTO attribute = attributeService.update(id, dto);
		return new ResponseEntity<>(attribute, HttpStatus.OK);
	}


	@Override
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        attributeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   
}

