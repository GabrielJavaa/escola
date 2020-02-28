package com.hbsis.sistemaescolar.materia;

import com.hbsis.sistemaescolar.nota.Nota;

import javax.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Long idmateria;

    @Column(name = "nome_materia",nullable = false)
    private String nomeMateria;

    @ManyToOne
    @JoinColumn(name = "id_nota", referencedColumnName = "id_nota")
    private Nota idNota;

    public Long getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Long idmateria) {
        this.idmateria = idmateria;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public Nota getIdNota() {
        return idNota;
    }

    public void setIdNota(Nota idNota) {
        this.idNota = idNota;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "idMateria=" + idmateria +
                ", nomeMateria='" + nomeMateria + '\'' +
                ", idNota=" + idNota +
                '}';
    }
}
