package org.example.service;

import org.example.model.Equipamento;

import java.util.List;

public interface InterfazEquipamientoService {
    List<Equipamento> listarTodos();

    //Create
    Equipamento añadirEquipamiento(Equipamento equipamiento);
    //Read
    Equipamento buscarPorId(Long id);
    //Update
    Equipamento actualizarEquipamiento(Equipamento equipamiento, Long id);
    //Delete
    void borrarEquipamiento(Long id);
    List<Equipamento> buscarPorEstado(Equipamento.EstadoEquipamento estado);
}
