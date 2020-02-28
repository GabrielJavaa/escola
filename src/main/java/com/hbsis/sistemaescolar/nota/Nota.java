package com.hbsis.sistemaescolar.nota;

import javax.persistence.*;

@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idnota;

    @Column(name = "nota_primeiro", nullable = false)
    private Double notaPrimeiro;

    @Column(name = "nota_segundo",nullable = false)
    private Double notaSegundo;

    @Column(name = "nota_terceiro",nullable = false)
    private Double notaTerceiro;

    @Column(name = "media_final",nullable = false)
    private Double mediaFinal;

    public Long getIdnota() {
        return idnota;
    }

    public void setIdnota(Long idnota) {
        this.idnota = idnota;
    }

    public Double getNotaPrimeiro() {
        return notaPrimeiro;
    }

    public void setNotaPrimeiro(Double notaPrimeiro) {
        this.notaPrimeiro = notaPrimeiro;
    }

    public Double getNotaSegundo() {
        return notaSegundo;
    }

    public void setNotaSegundo(Double notaSegundo) {
        this.notaSegundo = notaSegundo;
    }

    public Double getNotaTerceiro() {
        return notaTerceiro;
    }

    public void setNotaTerceiro(Double notaTerceiro) {
        this.notaTerceiro = notaTerceiro;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    @Override
    public String   toString() {
        return "Nota{" +
                "idNota=" + idnota +
                ", notaPrimeiro=" + notaPrimeiro +
                ", notaSegundo=" + notaSegundo +
                ", notaTerceiro=" + notaTerceiro +
                ", mediaFinal=" + mediaFinal +
                '}';
    }
}
