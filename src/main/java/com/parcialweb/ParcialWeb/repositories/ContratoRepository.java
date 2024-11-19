package com.parcialweb.ParcialWeb.repositories;

import com.parcialweb.ParcialWeb.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    Optional<Contrato> findById(Long id); // Personalizado si es necesario.

    List<Contrato> findAll(); // Personalizado si es necesario.

    boolean existsById(Long id); // Personalizado si es necesario.
}
