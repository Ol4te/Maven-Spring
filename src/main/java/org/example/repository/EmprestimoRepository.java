package org.example.repository;

import org.example.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByRetardadoTrue();
    List<Emprestimo> findByRetardado(Boolean retardado);
}
