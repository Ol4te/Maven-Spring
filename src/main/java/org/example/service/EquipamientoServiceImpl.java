package org.example.service;

import org.example.model.Equipamento;
import org.example.repository.EquipamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamientoServiceImpl implements InterfazEquipamientoService {
    private EquipamientoRepository repository;

    @Autowired
    public EquipamientoServiceImpl(EquipamientoRepository repository){
        this.repository= repository;
    }

    //Listar todos
    @Override
    public List<Equipamento> listarTodos(){
        return repository.findAll();
    }
    //CRUD
    @Override
    public Equipamento añadirEquipamiento(Equipamento equipamento){
        return repository.save(equipamento);
    }




    @Override
    public Equipamento buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Equipamento actualizarEquipamiento(Equipamento equipamento, Long id){
        Equipamento existente = repository.findById(id).orElse(null);
        if(existente == null) return null;
        equipamento.setId(existente.getId());
        return repository.save(equipamento);
    }

    @Override
    public void borrarEquipamiento(Long id){
        repository.deleteById(id);
    }

    public List<Equipamento> buscarPorEstado(Equipamento.EstadoEquipamento estado){
        return repository.findByEstado(estado);
    }




}
