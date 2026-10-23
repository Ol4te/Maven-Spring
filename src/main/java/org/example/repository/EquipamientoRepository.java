package org.example.repository;

import org.example.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamientoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findByEstado(Equipamento.EstadoEquipamento estado);

}
