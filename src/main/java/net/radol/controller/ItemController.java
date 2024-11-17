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

import net.radol.dto.ItemDTO;
import net.radol.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController implements CrudController<ItemDTO, Integer> {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ItemDTO>> getAll() {
        List<ItemDTO> items = itemService.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ItemDTO> getById(@PathVariable Integer id) {
        ItemDTO item = itemService.findById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO dto) {
        ItemDTO item = itemService.save(dto);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ItemDTO> update(@PathVariable Integer id, @RequestBody ItemDTO dto) {
        ItemDTO item = itemService.update(id, dto);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        itemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
