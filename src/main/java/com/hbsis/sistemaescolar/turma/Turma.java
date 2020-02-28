package com.hbsis.sistemaescolar.turma;

import com.hbsis.sistemaescolar.aluno.Aluno;

import javax.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Long idturma;

    @Column(name = "nome_turma", nullable = false, length = 10)
    private String nomeTurma;

    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno")
    private Aluno idAluno;

    public Long getIdturma() {
        return idturma;
    }

    public void setIdturma(Long id) {
        this.idturma = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "idTurma=" + idturma +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", idAluno=" + idAluno +
                '}';
    }
}
