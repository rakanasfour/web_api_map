package net.radol.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.radol.dto.UserDTO;
import net.radol.mapper.UserMapper;
import net.radol.model.User;
import net.radol.repository.UserRepository;
import net.radol.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO findById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO update(Integer id, UserDTO dto) {
        User user = userMapper.toEntity(dto);
        user.setUserId(id);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
