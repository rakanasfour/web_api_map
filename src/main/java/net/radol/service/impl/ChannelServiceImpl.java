package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.ChannelDTO;
import net.radol.mapper.ChannelMapper;
import net.radol.model.Channel;
import net.radol.repository.ChannelRepository;
import net.radol.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private final ChannelRepository channelRepository;
    private final ChannelMapper channelMapper;

    public ChannelServiceImpl(ChannelRepository channelRepository, ChannelMapper channelMapper) {
        this.channelRepository = channelRepository;
        this.channelMapper = channelMapper;
    }

    @Override
    public ChannelDTO save(ChannelDTO dto) {
        Channel channel = channelMapper.toEntity(dto);
        return channelMapper.toDTO(channelRepository.save(channel));
    }

    @Override
    public ChannelDTO findById(Integer id) {
        return channelRepository.findById(id)
                .map(channelMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Channel not found"));
    }

    @Override
    public List<ChannelDTO> findAll() {
        return channelRepository.findAll().stream()
                .map(channelMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChannelDTO update(Integer id, ChannelDTO dto) {
        Channel channel = channelMapper.toEntity(dto);
        channel.setChannelId(id);
        return channelMapper.toDTO(channelRepository.save(channel));
    }

    @Override
    public void deleteById(Integer id) {
        channelRepository.deleteById(id);
    }
}
