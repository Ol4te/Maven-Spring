package org.example.controller;

import org.example.model.Emprestimo;
import org.example.service.InterfazEmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {
    private InterfazEmprestimoService service;
    public EmprestimoController(InterfazEmprestimoService service){
        this.service = service;
    }

    //Listar todos

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }


    @PostMapping
    public ResponseEntity<Emprestimo> añadirEmprestimo(@RequestBody Emprestimo emprestimo){
        Emprestimo nuevo = service.añadirEmprestimo(emprestimo);
        return ResponseEntity.status(201).body(nuevo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimo(@PathVariable Long id){
        Emprestimo emprestimo = service.buscarEmprestimo(id);
        if(emprestimo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emprestimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> actualizarEmprestimo(@RequestBody Emprestimo emprestimo, @PathVariable Long id){
        Emprestimo actualizado = service.actualizarEmprestimo(emprestimo, id);
        if(actualizado == null) return ResponseEntity.notFound().build(); 
    }

}
