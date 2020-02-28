package com.hbsis.sistemaescolar.periodo;

import com.hbsis.sistemaescolar.nota.Nota;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "periodo")
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo")
    private Long idperiodo;

    @Column(name = "primeiro_trimestre",nullable = false)
    private LocalDate primeiroTrimestre;

    @Column(name = "segundo_trimestre",nullable = false)
    private LocalDate segundoTrimestre;

    @Column(name = "terceiro_trimestre",nullable = false)
    private LocalDate terceiroTrimestre;

    @ManyToOne
    @JoinColumn(name = "id_nota", referencedColumnName = "id_nota")
    private Nota idNota;


    public Long getIdPeriodo() {
        return idperiodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idperiodo = idPeriodo;
    }

    public LocalDate getPrimeiroTrimestre() {
        return primeiroTrimestre;
    }

    public void setPrimeiroTrimestre(LocalDate primeiroTrimestre) {
        this.primeiroTrimestre = primeiroTrimestre;
    }

    public LocalDate getSegundoTrimestre() {
        return segundoTrimestre;
    }

    public void setSegundoTrimestre(LocalDate segundoTrimestre) { this.segundoTrimestre = segundoTrimestre; }

    public LocalDate getTerceiroTrimestre() {
        return terceiroTrimestre;
    }

    public void setTerceiroTrimestre(LocalDate terceiroTrimestre) {
        this.terceiroTrimestre = terceiroTrimestre;
    }

    public Nota getIdNota() { return idNota; }

    public void setIdNota(Nota idNota) { this.idNota = idNota; }

    @Override
    public String toString() {
        return "Periodo{" +
                "idPeriodo=" + idperiodo +
                ", primeiroTrimestre=" + primeiroTrimestre +
                ", segundoTrimestre=" + segundoTrimestre +
                ", terceiroTrimestre=" + terceiroTrimestre +
                ", idNota=" + idNota +
                '}';
    }
}
