package org.example.service;

import org.example.model.Emprestimo;

import java.util.List;

public interface InterfazEmprestimoService {
    //MEtodo todos, CRUD Y buscar por Retrasados
    List<Emprestimo> buscarTodos();
    Emprestimo añadirEmprestimo(Emprestimo emprestimo);
    Emprestimo buscarEmprestimo(Long id);
    Emprestimo actualizarEmprestimo(Emprestimo emprestimo, Long id);
    void borrarEmprestimo(Long id);

    //añadir pero en void
    void añadirEmprestimo2(Emprestimo emprestimo);
    //buscar por retrasados
    List<Emprestimo> buscarPorRetrasado(Boolean esRetrasado);
}
