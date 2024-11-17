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

import net.radol.dto.ChannelDTO;
import net.radol.service.ChannelService;

@RestController
@RequestMapping("/api/channels")
public class ChannelController implements CrudController<ChannelDTO, Integer> {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ChannelDTO>> getAll() {
        List<ChannelDTO> channels = channelService.findAll();
        return new ResponseEntity<>(channels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ChannelDTO> getById(@PathVariable Integer id) {
        ChannelDTO channel = channelService.findById(id);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<ChannelDTO> create(@RequestBody ChannelDTO dto) {
        ChannelDTO channel = channelService.save(dto);
        return new ResponseEntity<>(channel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ChannelDTO> update(@PathVariable Integer id, @RequestBody ChannelDTO dto) {
        ChannelDTO channel = channelService.update(id, dto);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        channelService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
