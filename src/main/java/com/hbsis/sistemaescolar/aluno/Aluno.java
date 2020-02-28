package com.hbsis.sistemaescolar.aluno;

import com.hbsis.sistemaescolar.materia.Materia;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long idaluno;

    @Column(name = "nome_aluno", nullable = false)
    private String nomeAluno;

    public Long getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Long idaluno) {
        this.idaluno = idaluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "idaluno=" + idaluno +
                ", nomeAluno='" + nomeAluno + '\'' +
                '}';
    }
}
