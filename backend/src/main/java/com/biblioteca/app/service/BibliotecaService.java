package com.biblioteca.app.service;

import com.biblioteca.app.dto.BibliotecaDTO;
import com.biblioteca.app.model.Biblioteca;
import com.biblioteca.app.repository.BibliotecaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BibliotecaDTO> obtenerTodas() {
        return bibliotecaRepository.findAll()
                .stream()
                .map(biblioteca -> modelMapper.map(biblioteca, BibliotecaDTO.class))
                .collect(Collectors.toList());
    }

    public BibliotecaDTO obtenerPorId(Long id) {
        Biblioteca biblioteca = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Biblioteca no encontrada"));
        return modelMapper.map(biblioteca, BibliotecaDTO.class);
    }

    public BibliotecaDTO crear(BibliotecaDTO bibliotecaDTO) {
        Biblioteca biblioteca = modelMapper.map(bibliotecaDTO, Biblioteca.class);
        Biblioteca bibliotecaGuardada = bibliotecaRepository.save(biblioteca);
        return modelMapper.map(bibliotecaGuardada, BibliotecaDTO.class);
    }

    public BibliotecaDTO actualizar(Long id, BibliotecaDTO bibliotecaDTO) {
        Biblioteca biblioteca = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Biblioteca no encontrada"));

        biblioteca.setNombre(bibliotecaDTO.getNombre());
        biblioteca.setDireccion(bibliotecaDTO.getDireccion());
        biblioteca.setTelefono(bibliotecaDTO.getTelefono());
        biblioteca.setResponsable(bibliotecaDTO.getResponsable());

        Biblioteca bibliotecaActualizada = bibliotecaRepository.save(biblioteca);
        return modelMapper.map(bibliotecaActualizada, BibliotecaDTO.class);
    }

    public void eliminar(Long id) {
        bibliotecaRepository.deleteById(id);
    }
}
