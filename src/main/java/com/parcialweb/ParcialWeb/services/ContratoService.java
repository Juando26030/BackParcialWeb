package com.parcialweb.ParcialWeb.services;

import com.parcialweb.ParcialWeb.DTOs.ContratoDTO;
import com.parcialweb.ParcialWeb.model.Contrato;
import com.parcialweb.ParcialWeb.repositories.ContratoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Crear un nuevo contrato
    public ContratoDTO crearContrato(ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        Contrato contratoGuardado = contratoRepository.save(contrato); // Usando JpaRepository directamente
        return modelMapper.map(contratoGuardado, ContratoDTO.class);
    }

    // Actualizar un contrato existente
    public ContratoDTO actualizarContrato(Long id, ContratoDTO contratoDTO) {
        Optional<Contrato> contratoExistente = contratoRepository.findById(id); // Usando método personalizado
        if (contratoExistente.isEmpty()) {
            throw new RuntimeException("Contrato con ID " + id + " no encontrado.");
        }
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        contrato.setId(id);
        Contrato contratoActualizado = contratoRepository.save(contrato); // Usando JpaRepository directamente
        return modelMapper.map(contratoActualizado, ContratoDTO.class);
    }

    // Eliminar un contrato por su identificador
    public void eliminarContrato(Long id) {
        if (!contratoRepository.existsById(id)) { // Usando método personalizado
            throw new RuntimeException("Contrato con ID " + id + " no encontrado.");
        }
        contratoRepository.deleteById(id); // Usando JpaRepository directamente
    }

    // Consultar todos los contratos
    public List<ContratoDTO> obtenerTodosLosContratos() {
        List<Contrato> contratos = contratoRepository.findAll(); // Usando método personalizado
        return contratos.stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }

    // Consultar un contrato por su identificador
    public ContratoDTO obtenerContratoPorId(Long id) {
        Contrato contrato = contratoRepository.findById(id) // Usando método personalizado
                .orElseThrow(() -> new RuntimeException("Contrato con ID " + id + " no encontrado."));
        return modelMapper.map(contrato, ContratoDTO.class);
    }
}
