package org.example.controller;

import org.example.model.Equipamento;
import org.example.service.InterfazEquipamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {
    private InterfazEquipamientoService service;

    @Autowired
    public EquipamentoController(InterfazEquipamientoService interfaz){
        this.service = interfaz;
    }

    @GetMapping
    public ResponseEntity<List<Equipamento>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }


    @PostMapping
    public ResponseEntity<Equipamento> añadirEquipamiento(@RequestBody Equipamento equipamento){
        Equipamento nuevo = service.añadirEquipamiento(equipamento);
        return ResponseEntity.status(201).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable Long id){
        Equipamento equipamiento = service.buscarPorId(id);
        if(equipamiento == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(equipamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> actualizarEquipamiento(@RequestBody Equipamento equipamento, @PathVariable Long id){
        Equipamento actualizado = service.actualizarEquipamiento(equipamento, id);
        if(actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEquipamiento(@PathVariable Long id){
        service.borrarEquipamiento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Equipamento>> buscarEstado(@PathVariable Equipamento.EstadoEquipamento estado){

        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

}
