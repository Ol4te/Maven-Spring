package org.example.service;

import org.example.model.Emprestimo;
import org.example.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoServiceImpl implements InterfazEmprestimoService {
    private EmprestimoRepository repository;

    @Autowired
    public EmprestimoServiceImpl(EmprestimoRepository repository){
        this.repository = repository;
    }

    //Listar todos
    @Override
    public List<Emprestimo> buscarTodos(){
        return repository.findAll();
    }

    //CRUD

    @Override
    public Emprestimo añadirEmprestimo(Emprestimo emprestimo){
        return repository.save(emprestimo);
    }

    @Override
    public void añadirEmprestimo2(Emprestimo emprestimo){
        repository.save(emprestimo);
    }

    @Override
    public Emprestimo buscarEmprestimo(Long id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Emprestimo actualizarEmprestimo(Emprestimo emprestimo, Long id){
        Emprestimo existente = repository.findById(id).orElse(null);

        if(existente == null) return null;
        emprestimo.setId(existente.getId());
        return repository.save(emprestimo);
    }

    @Override
    public void borrarEmprestimo(Long id){
        repository.deleteById(id);
    }

    @Override
    public List<Emprestimo> buscarPorRetrasado(Boolean esretrasado){
        return repository.findByRetardado(esretrasado);
    }
}
