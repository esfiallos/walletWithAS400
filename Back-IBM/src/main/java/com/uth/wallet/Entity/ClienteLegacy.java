package com.uth.wallet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTES_LEGACY", schema = "EMERF1")
public class ClienteLegacy {

    @Id
    @Column(name = "ID_CLIENTE")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "SALDO")
    private BigDecimal saldo; // Usamos BigDecimal para dinero, nunca Double

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    // --- Getters y Setters  ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}