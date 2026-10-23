package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String tipo;

    private String modelo;

    @Column(unique = true)
    private String numeroSerie;

    private LocalDate dataCompra;

    private String observacions;

    @Enumerated(EnumType.STRING)
    private EstadoEquipamento estado;

    // CONSTRUCTORES

    public Equipamento() {
    }

    public Equipamento(
            Long id,
            String nome,
            String tipo,
            String modelo,
            String numeroSerie,
            LocalDate dataCompra,
            String observacions,
            EstadoEquipamento estado) {

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.dataCompra = dataCompra;
        this.observacions = observacions;
        this.estado = estado;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(
            String numeroSerie) {

        this.numeroSerie = numeroSerie;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(
            LocalDate dataCompra) {

        this.dataCompra = dataCompra;
    }

    public String getObservacions() {
        return observacions;
    }

    public void setObservacions(
            String observacions) {

        this.observacions = observacions;
    }

    public EstadoEquipamento getEstado() {
        return estado;
    }

    public void setEstado(
            EstadoEquipamento estado) {

        this.estado = estado;
    }

    // ENUM

    public enum EstadoEquipamento {

        DISPONIBEL,
        EMPRESTADO,
        MANUTENCION,
        BAIXA
    }
}