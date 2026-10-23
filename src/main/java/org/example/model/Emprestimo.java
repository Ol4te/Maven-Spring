package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    private String solicitante;

    private String email;

    private LocalDate dataLimiteDevolucion;

    private LocalDate dataDevolucionReal;

    private Boolean retardado;

    // CONSTRUCTORES

    public Emprestimo() {
    }

    public Emprestimo(
            Long id,
            Equipamento equipamento,
            String solicitante,
            String email,
            LocalDate dataLimiteDevolucion,
            LocalDate dataDevolucionReal,
            Boolean retardado) {

        this.id = id;
        this.equipamento = equipamento;
        this.solicitante = solicitante;
        this.email = email;
        this.dataLimiteDevolucion =
                dataLimiteDevolucion;
        this.dataDevolucionReal =
                dataDevolucionReal;
        this.retardado = retardado;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(
            Equipamento equipamento) {

        this.equipamento = equipamento;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(
            String solicitante) {

        this.solicitante = solicitante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public LocalDate
    getDataLimiteDevolucion() {

        return dataLimiteDevolucion;
    }

    public void setDataLimiteDevolucion(
            LocalDate dataLimiteDevolucion) {

        this.dataLimiteDevolucion =
                dataLimiteDevolucion;
    }

    public LocalDate
    getDataDevolucionReal() {

        return dataDevolucionReal;
    }

    public void setDataDevolucionReal(
            LocalDate dataDevolucionReal) {

        this.dataDevolucionReal =
                dataDevolucionReal;
    }

    public Boolean getRetardado() {
        return retardado;
    }

    public void setRetardado(
            Boolean retardado) {

        this.retardado = retardado;
    }
}